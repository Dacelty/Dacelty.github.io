use classicmodels;

-- Liệt kê tên các văn phòng theo tên thành phố và số lượng nhân viên thuộc các văn phòng đó
SELECT city, COUNT(employeeNumber) as SoLuongNhanVien
FROM offices o
INNER JOIN employees e ON o.officeCode = e.officeCode
GROUP BY city;

-- Liệt kê nước nào có số lượng văn phòng nhiều nhất
SELECT country, COUNT(officeCode) as SoLuongVanPhong
FROM offices o
GROUP BY country
ORDER BY COUNT(officeCode) DESC
LIMIT 1;

-- Liệt kê tình trạng các đơn hàng và số lượng đơn hàng thuộc tình trạng đó
SELECT status, COUNT(orderNumber) as SoLuongDonHangThuocTinhTrang
FROM orders o
GROUP BY status
ORDER BY COUNT(orderNumber) DESC;

-- Liệt kê productLine và số lượng sản phẩm thuộc các line đó
SELECT p.productLine, COUNT(p.productCode) as SoLuongSP
FROM products p
INNER JOIN productlines pl ON p.productLine = pl.productLine
GROUP BY productLine;

-- Liệt kê thông tin những đơn hàng bị hủy gồm: id đơn hàng, id khách hàng, tên khách hàng, orderDate, requireDate, nguyên nhân đơn hàng bị hủy (comment)
SELECT o.orderNumber, o.customerNumber, c.customerName, o.orderDate, o.requiredDate, o.comments
FROM orders o
INNER JOIN customers c ON o.customerNumber = c.customerNumber
GROUP BY o.orderNumber;

-- Liệt kê id đơn hàng, id khách hàng, tên khách hàng, orderDate, requireDate, sản phẩm (id, tên, số lượng) , comment của đơn hàng có id 10165
SELECT o.orderNumber, o.customerNumber, c.customerName, o.orderDate, o.requiredDate, od.productCode, p.productName, od.quantityOrdered, o.comments
FROM orders o
INNER JOIN customers c ON o.customerNumber = c.customerNumber
INNER JOIN orderdetails od ON o.orderNumber = od.orderNumber
INNER JOIN products p ON p.productCode = od.productCode
WHERE o.orderNumber = 10165;

-- Liệt kê thông tin các nhân viên thực hiện công việc Sales Rep làm việc ở văn phòng San Francisco
SELECT e.employeeNumber, e.lastName, e.firstName, e.extension, e.email, e.jobTitle, e.officeCode, o.city
FROM employees e
INNER JOIN offices o ON e.officeCode = o.officeCode
WHERE e.jobTitle = 'Sales Rep' AND o.city = 'San Francisco';


-- Liệt kê thông 5 khách hàng order nhiều nhất
SELECT c.customerNumber, c.customerName, c.phone, c.addressLine1, c.addressLine2, c.city, c.state, c.postalCode, c.country, COUNT(o.customerNumber) AS SoLanOrder
FROM orders o
INNER JOIN customers c ON o.customerNumber = c.customerNumber
GROUP BY o.customerNumber
ORDER BY COUNT(o.customerNumber) DESC
LIMIT 5;

-- Tạo store procedure lấy ra thông tin id đơn hàng, id khách hàng, tên khách hàng, orderDate, requireDate, shippedDate, sản phẩm (id, tên, số lượng), comment, với tham số truyền vào là status
DELIMITER //

CREATE PROCEDURE CustomerAndOrder(
	IN statusInput VARCHAR(255)
)
BEGIN
	SELECT o.orderNumber, o.customerNumber, c.customerName, o.orderDate, o.requiredDate, od.productCode, p.productName, od.quantityOrdered, o.comments, o.status
	FROM orders o
	INNER JOIN customers c ON o.customerNumber = c.customerNumber
	INNER JOIN orderdetails od ON o.orderNumber = od.orderNumber
	INNER JOIN products p ON p.productCode = od.productCode
	WHERE o.status = statusInput
    GROUP BY o.orderNumber;
END //

DELIMITER ;

DROP PROCEDURE CustomerAndOrder;