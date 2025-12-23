package com.example.cameraapp.model

data class TongueImage(
    val id: String,
    val imageResId: Int,    // drawable资源ID
    val description: String, // 图片描述
    val type: TongueType    // 舌头类型
)

enum class TongueType {
    NORMAL,      // 正常舌头
    RED_TONGUE,  // 红舌
    PURPLE_TONGUE, // 紫舌
    SWOLLEN,     // 胖大舌
    THIN,        // 瘦薄舌
    CRACKED      // 裂纹舌
}