package com.example.cameraapp.model

import com.example.cameraapp.R

data class TongueReport(
    // 基础信息
    val id: String = "",
    val timestamp: Long = System.currentTimeMillis(),

    // 健康评分
    val score: Int = 76,
    val summary: String = "整体不错，但脾胃需要特别关照",

    // 舌头图片资源ID
    val tongueImageRes: Int = R.drawable.tongue_sample_1,

    // 区域分析（按策划书要求）
    val regions: List<Region> = listOf(
        Region(organ = "心", score = 85, emoji = "😊"),
        Region(organ = "脾", score = 60, emoji = "🤢"),
        Region(organ = "肝", score = 75, emoji = "😠"),
        Region(organ = "肾", score = 70, emoji = "🥱")
    ),

    // 建议
    val suggestions: List<String> = listOf(
        "饮食清淡，少吃油腻",
        "每天散步30分钟",
        "保持心情舒畅"
    )
)