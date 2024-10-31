-- Create Database
CREATE DATABASE UserManagement;
GO

-- Use the newly created database
USE UserManagement;
GO

-- Create tblUsers table
CREATE TABLE tblUsers(
    userID NVARCHAR(50) PRIMARY KEY,
    fullName NVARCHAR(50) NOT NULL,
    password NVARCHAR(50) NOT NULL,
    roleID NVARCHAR(50) NOT NULL,
    [status] BIT NULL
);
GO

-- Insert data into tblUsers
INSERT INTO tblUsers (userID, fullName, password, roleID, [status]) VALUES 
(N'admin', N'Toi la admin', N'1', N'AD', 1),
(N'Hoadnt', N'Hoa Doan', N'1', N'US', 1),
(N'SE130363', N'Ngo Ha Tri Bao', N'1', N'AD', 1),
(N'SE140103', N'Phuoc Ha', N'1', N'US', 1),
(N'SE140119', N'Trai Nguyen', N'1', N'AD', 1),
(N'SE140130', N'Tam Tran', N'1', N'AD', 1),
(N'SE140201', N'PHAM HOANG TU', N'1', N'AD', 1),
(N'SE140969', N'Nguyen Gia Tin', N'123', N'US', 1),
(N'sonnh', N'Son Hong', N'1', N'US', NULL);
GO

-- Create tblOrders table
CREATE TABLE tblOrders(
    orderID INT PRIMARY KEY,
    orderDate DATE,
    total FLOAT,
    userID NVARCHAR(50) FOREIGN KEY REFERENCES tblUsers(userID)
);
GO

-- Create tblProducts table
CREATE TABLE tblProducts(
    productID NVARCHAR(10) PRIMARY KEY,
    productName NVARCHAR(50),
    price INT,
    quantity INT,
    status BIT
);
GO

-- Insert data into tblProducts
INSERT INTO tblProducts (productID, productName, price, quantity, status) VALUES 
(N'T00', N'Marble Olong Green Tea', 10, 19, 1),
(N'T01', N'Hi-Milk Ice Coffee Fresh', 20, 50, 1),
(N'T02', N'Olong Fabric Croissant', 100, 82, 1),
(N'T03', N'Hi-Tea Yuzu Pearl Orange', 30, 191, 1),
(N'T04', N'Butter Olong Milk Tea', 60, 146, 1),
(N'T05', N'Ice Blended Frosty Green Tea', 21, 95, 1),
(N'T06', N'Bread With Cheese Floss', 32, 245, 1),
(N'T07', N'Butter Croissant Condensed Milk', 9, 70, 1),
(N'T08', N'CloudTea Green Tea', 10, 23, 1),
(N'T09', N'CloudTea Oolong Berry', 12, 34, 1),
(N'T10', N'Roasted Milk Tea with Flute', 18, 63, 1),
(N'T11', N'Fresh Strawberry Cheese', 10, 122, 1),
(N'T12', N'Fresh Custard Cheese', 23, 222, 1),
(N'T13', N'Arabica Butter Cheese', 12, 153, 1),
(N'T14', N'Iced Caramel Macchiato', 33, 332, 1),
(N'T15', N'Hot Latte Raspberry', 5, 221, 1),
(N'T16', N'Hi-Tea Peach Kombucha', 12, 345, 1),
(N'T17', N'Black Sugar Green Tea', 21, 31, 1),
(N'T18', N'Frosty Phin-Gato Cream', 32, 45, 1),
(N'T19', N'Frosty Black Sugar Coffee', 18, 345, 1),
(N'T20', N'Frosty Strawberry Cream Cake', 19, 689, 1),
(N'T21', N'Frosty Choco Chip', 16, 324, 1),
(N'T22', N'Coconut Ice Cream Mochi', 19, 21, 1),
(N'T23', N'Mochi Cream Chocolate', 31, 976, 1),
(N'T24', N'Chocolate Bear Mousse', 29, 43, 1),
(N'T25', N'Roasted Choco Croffle', 8, 231, 1),
(N'T26', N'Raspberry Ice Cream Mochi', 11, 74, 1);
GO

-- Create tblOrderDetail table
CREATE TABLE tblOrderDetail(
    orderID INT NOT NULL,
    productID NVARCHAR(10) NOT NULL,
    price FLOAT,
    quantity INT,
    PRIMARY KEY(orderID, productID),
    FOREIGN KEY(orderID) REFERENCES tblOrders(orderID),
    FOREIGN KEY(productID) REFERENCES tblProducts(productID)
);
GO
