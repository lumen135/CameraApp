# CameraApp - 远程拍照控制应用

## 项目简介
这是一个Android应用，用于远程控制拍照并与A同学的服务端通信。

## 已完成功能
- ✅ 基础界面布局
- ✅ 网络连接测试
- ✅ 模拟拍照功能
- ✅ 状态显示和进度提示

## 项目结构
   ```
   CameraApp/
   ├── app/src/main/java/com/example/cameraapp/
   │   ├── MainActivity.kt      # 主活动
   │   └── NetworkManager.kt    # 网络管理
   ├── app/src/main/res/layout/
   │   └── activity_main.xml    # 界面布局
   ├── app/src/main/AndroidManifest.xml
   └── README.md
   ```
   
   ## 如何运行
   1. 克隆项目：`git clone https://github.com/你的用户名/CameraApp.git`
   2. 用Android Studio打开项目
   3. 连接手机或启动模拟器
   4. 运行应用
   
   ## 测试步骤
   1. 输入服务器IP地址（如192.168.1.100）
   2. 点击"测试连接"
   3. 连接成功后，点击"拍照"按钮
   
   ## 等待A同学
   - 需要A同学提供真实的服务器IP
   - 下一步实现真实的HTTP通信
   
   ## 提交记录
   - B：完成A服务连接（当前版本）
   ```
