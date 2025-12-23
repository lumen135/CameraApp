package com.example.cameraapp  // 注意：这是你的包名！

import android.content.Context
import android.graphics.Bitmap
import android.os.AsyncTask
import android.util.Log
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.InetSocketAddress
import java.net.Socket

/**
 * 网络管家 - 负责所有网络相关操作
 */
class NetworkManager(private val context: Context) {

    // 服务器配置
    companion object {
        // TODO: 请A同学提供实际IP
        private const val SERVER_IP = "127.0.0.1"
        private const val SERVER_PORT = 8080
        private const val TAG = "NetworkManager"
        private const val CONNECT_TIMEOUT = 5000
        private const val READ_TIMEOUT = 10000

        // API 接口
        private const val API_UPLOAD = "/upload"
        private const val API_TEST = "/test"
    }

    /**
     * 测试服务器连接
     */
    fun testConnection(callback: (Boolean, String) -> Unit) {
        Log.d(TAG, "开始测试连接: $SERVER_IP:$SERVER_PORT")

        AsyncTask.execute {
            try {
                // 创建socket连接
                val socket = Socket()
                val address = InetSocketAddress(SERVER_IP, SERVER_PORT)

                socket.connect(address, CONNECT_TIMEOUT)
                val isConnected = socket.isConnected
                socket.close()

                if (isConnected) {
                    val msg = "✅ 连接成功！\n服务器: $SERVER_IP\n端口: $SERVER_PORT"
                    Log.i(TAG, msg)
                    callback(true, msg)
                } else {
                    val msg = "❌ 连接失败"
                    Log.w(TAG, msg)
                    callback(false, msg)
                }

            } catch (e: Exception) {
                val errorMsg = "❌ 连接异常: ${e.localizedMessage ?: "未知错误"}"
                Log.e(TAG, errorMsg, e)
                callback(false, errorMsg)
            }
        }
    }

    /**
     * 发送图片到服务器
     */
    fun capturePhoto(bitmap: Bitmap, callback: (Boolean, String, String?) -> Unit) {
        Log.d(TAG, "开始发送图片，大小: ${bitmap.width}x${bitmap.height}")

        AsyncTask.execute {
            try {
                // 1. 压缩图片
                val outputStream = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream)
                val imageData = outputStream.toByteArray()
                outputStream.close()

                Log.d(TAG, "图片压缩后大小: ${imageData.size / 1024} KB")

                // 2. 创建HTTP连接
                val url = URL("http://$SERVER_IP:$SERVER_PORT$API_UPLOAD")
                val connection = url.openConnection() as HttpURLConnection

                // 3. 设置请求头
                connection.requestMethod = "POST"
                connection.doOutput = true
                connection.connectTimeout = CONNECT_TIMEOUT
                connection.readTimeout = READ_TIMEOUT
                connection.setRequestProperty("Content-Type", "image/jpeg")
                connection.setRequestProperty("Content-Length", imageData.size.toString())
                connection.setRequestProperty("User-Agent", "TongueMirror-App/1.0")

                // 4. 发送数据
                connection.outputStream.use { os ->
                    os.write(imageData)
                    os.flush()
                }

                // 5. 获取响应
                val responseCode = connection.responseCode

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val response = connection.inputStream.bufferedReader().use { it.readText() }
                    val successMsg = "✅ 图片发送成功！\n服务器响应: $response"
                    Log.i(TAG, successMsg)
                    callback(true, successMsg, response)
                } else {
                    val errorMsg = "❌ 服务器错误: $responseCode"
                    Log.w(TAG, errorMsg)
                    callback(false, errorMsg, null)
                }

                connection.disconnect()

            } catch (e: Exception) {
                val errorMsg = "❌ 发送失败: ${e.localizedMessage ?: "网络错误"}"
                Log.e(TAG, errorMsg, e)
                callback(false, errorMsg, null)
            }
        }
    }

    /**
     * 获取服务器状态信息
     */
    fun getServerStatus(): String {
        return buildString {
            append("📡 服务器状态\n")
            append("────────────\n")
            if (SERVER_IP == "等待A") {
                append("⚠️ 等待配置服务器IP\n")
                append("请A同学提供服务器地址\n")
            } else {
                append("✅ IP: $SERVER_IP\n")
                append("✅ 端口: $SERVER_PORT\n")
                append("✅ 状态: 待连接\n")
            }
        }
    }

    /**
     * 简单的ping测试
     */
    fun pingServer(callback: (Int) -> Unit) {
        AsyncTask.execute {
            try {
                val startTime = System.currentTimeMillis()
                val socket = Socket()
                socket.connect(InetSocketAddress(SERVER_IP, SERVER_PORT), 3000)
                socket.close()
                val pingTime = System.currentTimeMillis() - startTime

                Log.i(TAG, "Ping成功，延迟: ${pingTime}ms")
                callback(pingTime.toInt())
            } catch (e: Exception) {
                Log.e(TAG, "Ping失败", e)
                callback(-1)
            }
        }
    }
}