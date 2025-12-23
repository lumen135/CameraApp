package com.example.cameraapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuideScreen(
    onStartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 太极图标
        Text(
            text = "☯",
            fontSize = 72.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 主标题
        Text(
            text = "舌诊镜",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2E7D32)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 副标题
        Text(
            text = "传统中医智慧 · 现代科技呈现",
            fontSize = 18.sp,
            color = Color(0xFF558B2F)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // 步骤说明
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "📝 使用步骤：",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF388E3C)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "1️⃣ 准备环境\n   在自然光下，保持口腔清洁\n\n" +
                        "2️⃣ 拍摄舌头\n   伸出舌头，对准镜头\n\n" +
                        "3️⃣ 智能分析\n   AI分析舌象健康状况\n\n" +
                        "4️⃣ 查看报告\n   获取个性化中医建议",
                fontSize = 16.sp,
                color = Color(0xFF666666),
                lineHeight = 24.sp
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // 开始按钮
        Button(
            onClick = onStartClick,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50)
            )
        ) {
            Text(
                text = "开始舌诊",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 小贴士
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFC8E6C9)
            )
        ) {
            Text(
                text = "💡 中医小贴士：舌诊最好在早上空腹时进行",
                modifier = Modifier.padding(16.dp),
                fontSize = 14.sp,
                color = Color(0xFF388E3C)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuideScreenPreview() {
    GuideScreen(
        onStartClick = {},
        modifier = Modifier.fillMaxSize()
    )
}