package data

import com.example.cameraapp.R
import com.example.cameraapp.model.Region
import com.example.cameraapp.model.TongueReport
import com.example.cameraapp.model.TongueImage
import com.example.cameraapp.model.TongueType

object MockTongueData {
    // 模拟舌头报告
    fun getMockReport(): TongueReport {
        return TongueReport(
            id = "report_001",
            timestamp = System.currentTimeMillis(),
            score = 76,
            summary = "整体不错，但脾胃需要特别关照",
            tongueImageRes = R.drawable.tongue_sample_1,
            regions = listOf(
                Region(organ = "心", score = 85, emoji = "😊", analysis = "心脏功能良好，气血充足"),
                Region(organ = "脾", score = 60, emoji = "🤢", analysis = "脾虚湿盛，需调理饮食"),
                Region(organ = "肝", score = 75, emoji = "😠", analysis = "肝火稍旺，注意情绪"),
                Region(organ = "肾", score = 70, emoji = "🥱", analysis = "肾气不足，注意休息"),
                Region(organ = "肺", score = 80, emoji = "😌", analysis = "肺功能正常，呼吸通畅")
            ),
            suggestions = listOf(
                "饮食清淡，少吃油腻食物",
                "每天散步30分钟，促进消化",
                "保持心情舒畅，避免生气",
                "晚上11点前睡觉，养肝护肾"
            )
        )
    }

    // 获取多个报告
    fun getMockReports(): List<TongueReport> {
        return listOf(
            getMockReport(),
            TongueReport(
                id = "report_002",
                timestamp = System.currentTimeMillis() - 86400000, // 昨天
                score = 82,
                summary = "健康状况良好，继续保持",
                tongueImageRes = R.drawable.tongue_sample_2
            ),
            TongueReport(
                id = "report_003",
                timestamp = System.currentTimeMillis() - 172800000, // 前天
                score = 68,
                summary = "肝火较旺，注意调节",
                tongueImageRes = R.drawable.tongue_sample_3
            )
        )
    }

    // 舌头图片示例
    fun getTongueImages(): List<TongueImage> {
        return listOf(
            TongueImage("1", R.drawable.tongue_sample_1, "正常舌头", TongueType.NORMAL),
            TongueImage("2", R.drawable.tongue_sample_2, "红舌 - 热证", TongueType.RED_TONGUE),
            TongueImage("3", R.drawable.tongue_sample_3, "齿痕舌 - 脾虚", TongueType.SWOLLEN)
        )
    }

    // 获取健康小贴士
    fun getHealthTips(): List<String> {
        return listOf(
            "👅 舌诊小知识：正常舌象应为淡红舌、薄白苔",
            "🌿 脾胃虚弱者建议：小米粥、山药、红枣",
            "💤 晚上11点前睡觉有助于肝胆排毒",
            "💧 每天喝够8杯水，保持身体代谢",
            "😊 保持心情愉悦，肝气舒畅"
        )
    }
}