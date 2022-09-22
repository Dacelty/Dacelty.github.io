// Danh sách các sản phẩm có trong giỏ hàng
let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]

// 1. In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
// Tên - Giá - Thương Hiệu - Số lượng
// Ví dụ : OPPO Find X3 Pro - 19500000 - OPPO - 3

// 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
// Tổng tiền mỗi sản phẩm = price * count

// 3. Tìm các sản phẩm của thuơng hiệu "Apple"

// 4. Tìm các sản phẩm có giá > 20000000

// 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)

// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product

// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng

// 8. Sắp xếp giỏ hàng theo price tăng dần

// 9. Sắp xếp giỏ hàng theo count giảm dần

// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng

console.log('Câu 1:');
for (const key in products) {
    console.log(products[key].name + " - " + products[key].price + " - " + products[key].brand + " - " + products[key].count);
}

console.log('Câu 2:');
for (const key in products) {
    console.log('Tổng tiền SP ' + products[key].name + ': ' + (products[key].price*products[key].count));
}

console.log('Câu 3:');
for (const key in products) {
    if (products[key].brand == 'Apple'){
        console.log(products[key]);
    }
}

console.log('Câu 4:');
for (const key in products) {
    if (products[key].price > 20000000){
        console.log(products[key]);
    }
}

console.log('Câu 5:');
for (const key in products) {
    if (products[key].name.includes('Pro') || products[key].name.includes('pro')){
        console.log(products[key]);
    }
}

console.log('Câu 6:');
products.push({
    name: "Iphone 13 Pro Max2223", 
    price: 3000000, 
    brand: "Apple", 
    count: 2, 
})
for (const key in products) {
    console.log(products[key]);
}