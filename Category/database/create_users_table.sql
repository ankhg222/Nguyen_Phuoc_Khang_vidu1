-- SQL Script để tạo bảng users cho chức năng profile
-- Chạy script này trong SQL Server Management Studio

USE [User]; -- Thay đổi tên database nếu cần
GO

-- Tạo bảng users nếu chưa tồn tại
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='users' AND xtype='U')
BEGIN
    CREATE TABLE [dbo].[users] (
        [id] INT IDENTITY(1,1) NOT NULL,
        [username] NVARCHAR(50) NOT NULL UNIQUE,
        [password] NVARCHAR(255) NOT NULL,
        [email] NVARCHAR(100) NOT NULL UNIQUE,
        [fullname] NVARCHAR(100) NULL,
        [phone] NVARCHAR(20) NULL,
        [images] NVARCHAR(500) NULL,
        [roleid] INT NOT NULL DEFAULT 2,
        [active] BIT NOT NULL DEFAULT 1,
        [code] NVARCHAR(50) NULL,
        [createDate] DATE NULL DEFAULT GETDATE(),
        
        CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED ([id] ASC)
    );
END
GO

-- Thêm dữ liệu mẫu
IF NOT EXISTS (SELECT * FROM users WHERE username = 'admin')
BEGIN
    INSERT INTO [dbo].[users] 
    ([username], [password], [email], [fullname], [phone], [images], [roleid], [active], [createDate])
    VALUES 
    ('admin', '123456', 'admin@example.com', 'Administrator', '0123456789', 'default-avatar.jpg', 1, 1, GETDATE()),
    ('user1', '123456', 'user1@example.com', 'Nguyễn Văn A', '0987654321', 'default-avatar.jpg', 2, 1, GETDATE()),
    ('user2', '123456', 'user2@example.com', 'Trần Thị B', '0912345678', 'default-avatar.jpg', 2, 1, GETDATE());
END
GO

-- Kiểm tra dữ liệu
SELECT * FROM users;
GO

PRINT 'Tạo bảng users và dữ liệu mẫu thành công!';
GO