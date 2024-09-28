CREATE DATABASE FA24_BL1_WORKSHOP_DEMO;
GO
USE FA24_BL1_WORKSHOP_DEMO;
GO
CREATE TABLE may_tinh(
	id int PRIMARY KEY IDENTITY NOT NULL ,
	ma varchar(100),
	ten nvarchar(100),
	gia float,
	bo_nho nvarchar(100),
	mau_sac nvarchar(100),
	hang nvarchar(100),
	mieu_ta nvarchar(100)
)
GO 
INSERT INTO may_tinh
( ma, ten, gia, bo_nho, mau_sac, hang, mieu_ta)
VALUES(N'MT01', N'Máy a', 10.0, N'512GB', N'Xám', N'Apple', N'Sản phẩm đẹp');
INSERT INTO may_tinh
(ma, ten, gia, bo_nho, mau_sac, hang, mieu_ta)
VALUES( N'MT02', N'Máy b', 11.0, N'256GB', N'Đỏ', N'Dell', N'Sản phẩm hơi dày');
