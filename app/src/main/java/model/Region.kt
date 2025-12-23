package com.example.cameraapp.model

data class Region(
    val organ: String,          // 器官名称：心、肝、脾、肺、肾
    val score: Int,             // 该区域健康评分 0-100
    val emoji: String,          // 表情符号
    val analysis: String = ""   // 详细分析（可选）
) {
    // 根据评分获取颜色
    fun getColorCode(): String {
        return when (score) {
            in 80..100 -> "#4CAF50"  // 优秀 - 绿色
            in 60..79 -> "#FFC107"   // 良好 - 黄色
            else -> "#F44336"        // 需要关注 - 红色
        }
    }

    // 获取健康状态描述
    fun getStatus(): String {
        return when (score) {
            in 80..100 -> "健康"
            in 60..79 -> "一般"
            else -> "需要关注"
        }
    }
}