const grades = [
    {name: 'John', grade: 8, sex: 'M'},
    {name: 'Sarah', grade: 12, sex: 'F'},
    {name: 'Bob', grade: 16, sex: 'M'},
    {name: 'Johnny', grade: 2, sex: 'M'},
    {name: 'Ethan', grade: 4, sex: 'M'},
    {name: 'Paula', grade: 18, sex: 'F'},
    {name: 'Donald', grade: 5, sex: 'M'},
    {name: 'Jennifer', grade: 13, sex: 'F'},
    {name: 'Courtney', grade: 15, sex: 'F'},
    {name: 'Jane', grade: 9, sex: 'F'}
]

console.log('Bài 1');
function b1() {
    let soHS = 0;
    let dTong = 0;
    for (const key in grades) {
        soHS++;
        dTong += grades[key].grade;
    }
    console.log('Tổng HS: ' + soHS);
    console.log('Tổng thứ hạng: ' + dTong);
    return dTong/soHS;
}
console.log(b1());

console.log('---------------------------------')
console.log('Bài 2');
function b2() {
    let soHS = 0;
    let dTong = 0;
    for (const key in grades) {
        if (grades[key].sex == 'M'){
            soHS++;
            dTong += grades[key].grade;
        }

    }
    console.log('Tổng HS nam: ' + soHS);
    console.log('Tổng thứ hạng của các HS nam: ' + dTong);
    return dTong/soHS;
}
console.log(b2());

console.log('---------------------------------')
console.log('Bài 3');
function b3() {
    let soHS = 0;
    let dTong = 0;
    for (const key in grades) {
        if (grades[key].sex == 'F'){
            soHS++;
            dTong += grades[key].grade;
        }

    }
    console.log('Tổng HS nữ: ' + soHS);
    console.log('Tổng thứ hạng của các HS nam: ' + dTong);
    return dTong/soHS;
}
console.log(b3());

console.log('---------------------------------')
console.log('Bài 4');
function b4() {
    let diemCaoNhat = 0;
    let b4 = [];
    for (const key in grades) {
        if (grades[key].grade > diemCaoNhat && grades[key].sex == 'M'){
            diemCaoNhat=grades[key].grade;
        }
    }
    for (const key in grades) {
        if (grades[key].grade == diemCaoNhat && grades[key].sex == 'M'){
            b4.push(grades[key]);
            break;
        }
    }
    return b4;
}
console.log(b4());

console.log('---------------------------------')
console.log('Bài 5');
function b5() {
    let diemCaoNhat = 0;
    let b5 = [];
    for (const key in grades) {
        if (grades[key].grade > diemCaoNhat && grades[key].sex == 'F'){
            diemCaoNhat=grades[key].grade;
        }
    }
    for (const key in grades) {
        if (grades[key].grade == diemCaoNhat && grades[key].sex == 'F'){
            b5.push(grades[key]);
            break;
        }
    }
    return b5;
}
console.log(b5());

console.log('---------------------------------')
console.log('Bài 6');
function b6() {
    let diemThapNhat = 100;
    let b6 = [];
    for (const key in grades) {
        if (grades[key].grade < diemThapNhat && grades[key].sex == 'M'){
            diemThapNhat=grades[key].grade;
        }
    }
    for (const key in grades) {
        if (grades[key].grade == diemThapNhat && grades[key].sex == 'M'){
            b6.push(grades[key]);
            break;
        }
    }
    return b6;
}
console.log(b6());

console.log('---------------------------------')
console.log('Bài 7');
function b7() {
    let diemThapNhat = 100;
    let b7 = [];
    for (const key in grades) {
        if (grades[key].grade < diemThapNhat && grades[key].sex == 'F'){
            diemThapNhat=grades[key].grade;
        }
    }
    for (const key in grades) {
        if (grades[key].grade == diemThapNhat && grades[key].sex == 'F'){
            b7.push(grades[key]);
            break;
        }
    }
    return b7;
}
console.log(b7());

console.log('---------------------------------')
console.log('Bài 8');
function b8() {
    let diemCaoNhat = 0;
    for (const key in grades) {
        if (grades[key].grade > diemCaoNhat){
            diemCaoNhat=grades[key].grade;
        }
    }
    return diemCaoNhat;
}
console.log(b8());

console.log('---------------------------------')
console.log('Bài 9');
function b9() {
    let diemThapNhat = 100;
    for (const key in grades) {
        if (grades[key].grade < diemThapNhat){
            diemThapNhat=grades[key].grade;
        }
    }
    return diemThapNhat;
}
console.log(b9());

console.log('---------------------------------')
console.log('Bài 10');
function b10() {
    let dsHSNu = [];
    for (const key in grades) {
        if (grades[key].sex == 'F'){
            dsHSNu.push(grades[key]);
        }
    }
    return dsHSNu;
}
console.log(b10());

console.log('---------------------------------')
console.log('Bài 11');
function b11() {
    let sorted = grades.sort((a,b) => a.name.localeCompare(b.name));
    return sorted;
}
console.log(b11());

console.log('---------------------------------')
console.log('Bài 12');
function b12() {
    let sorted = grades.sort((a,b) => b.grade-a.grade);
    return sorted;
}
console.log(b12());

console.log('---------------------------------')

console.log('Bài 13');
function b13() {
    const b13 = [];
    for (const key in grades) {
        if (grades[key].name.split('',1) == 'J' && grades[key].sex == 'F'){
            b13.push(grades[key]);
        }
    }
    return b13;
}
console.log(b13());

console.log('---------------------------------')
console.log('Bài 14');
function b14(){
    //tạo mảng mới sao cho 5 người có thứ hạng cao nhất ở đầu mảng
    let shuffled = grades.sort((a,b) => b.grade - a.grade);
    //tạo mảng mới trả về 5 phần tử bắt đầu từ phần tử đầu tiên
    let selected = shuffled.slice(0, 5);
    return selected;
}
console.log(b14());