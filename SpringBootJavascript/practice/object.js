let student = {
    name: "Nguyễn Văn A",
    age: 19,
    email: "nguyenvana@gmail.com"
}
console.log(Object.keys(student));
console.log(Object.values(student));

console.log(student.hasOwnProperty("email"));
console.log(student.hasOwnProperty("name"));