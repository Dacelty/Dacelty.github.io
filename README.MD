## Giới thiệu về HTML

`HTML` là viết tắt của **Hyper Text Markup Language** (ngôn ngữ đánh dấu siêu văn bản).

`HTML` cho _phép người dùng tạo và cấu trúc hóa các thành phần_ trên một trang web như đoạn văn, tiêu đề, liên kết, trích dẫn, bảng biểu…

### Chương trình đầu tiên

> Tạo file index.html có nội dung như sau

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Trang web đầu tiên</title>
  </head>
  <body>
    <h1 style="color: rgb(255, 0, 0)">Xin chào các bạn. Đây là thẻ h1.</h1>

    <div style="color: green; background-color: gold; width: 1000px">
      <h2>Đây là thẻ h2.</h2>
      <h3>Đây là thẻ h3.</h3>
      <h4 style="text-transform: uppercase">Đây là thẻ h4.</h4>
      <h5 style="text-align: center">Đây là thẻ h5.</h5>
      <h6>Đây là thẻ h6.</h6>
    </div>

    <h2>Dưới đây là thẻ paragraph.</h2>
    <p>
      <span style="font-weight: bold"
        >Lorem ipsum dolor sit amet consectetur adipisicing elit.</span
      >
      Repudiandae eum, impedit sapiente accusamus deserunt sunt labore maxime
      quisquam voluptatem ipsum explicabo quia consequuntur, non fuga, qui
      obcaecati enim pariatur rerum.
    </p>

    <h2>Dưới đây là thẻ link.</h2>
    <a href="https://google.com" target="_blank">Đi đến trang google.com.</a>
    <!-- Thuộc tính target="_blank" sẽ mở google ở trong 1 tab mới. -->

    <!-- Menu giữa các trang -->
    <a href="./index.html" style="text-decoration: none">Trang chủ</a>
    <a href="./shop.html">Shop</a>
    <a href="./about.html">Liên hệ</a>
    <br />

    <!-- Thẻ ảnh -->
    <img
      style="display:block; "
      src="https://images.unsplash.com/photo-1652267991886-f94511880d7a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
      alt="Ảnh con bò."
      width="500"
    />

    <!-- Thẻ danh sách không có thứ tự -->
    <h3>Danh sách nhân viên xuất sắc tháng 5</h3>
    <ul>
      <li>Nguyễn Văn A</li>
      <li>Trần Văn B</li>
      <li>Ngô Thị C</li>
    </ul>

    <!-- Thẻ danh sách có thứ tự -->
    <h3>Danh sách nhân viên xuất sắc tháng 6</h3>
    <ol>
      <li>Nguyễn Văn A</li>
      <li>Trần Văn B</li>
      <li>Ngô Thị C</li>
    </ol>

    <!-- Cú pháp tạo nhanh danh sách : ul>li*5 -->
    <ul>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </body>
</html>
```

Nội dung file `style.css` như sau

```css
h2 {
  color: red;
}

/* Dùng ID. Dùng dấu thăng */
#heading {
  color: blue;
}

p {
  color: cornflowerblue;
}

/* Dùng Class. Dùng dấu chấm */
.text {
  background-color: bisque;
}
.text1 {
  font-size: larger;
}

/* Có thể chọn 2 class cùng 1 lúc. Có thể chọn lẫn cả phần từ + ID + class.*/
.text.text1 {
}

.box p {
  font-weight: bold;
}

h2,
p {
  text-align: center;
}

/* Chọn thẻ p vừa có cả class text+tex1 */
p.text.text1 {
  font-size: x-small;
}

/* KHI ĐỌC CSS LUÔN ĐỌC TỪ PHẢI SANG TRÁI */
```

### Tài liệu xếp

1. https://www.w3schools.com/html/default.asp
2. https://www.w3schools.com/html/default.asp

- https://www.w3schools.com/html/default.asp
- https://www.w3schools.com/html/default.asp

### Code tham khảo
- [Buổi học số 1](./day_01/index.html)
- [Buổi học số 2](./day_02/card/index.html)

### Chèn ảnh
![VD](./day_01/image/-1TW4mkP.png)