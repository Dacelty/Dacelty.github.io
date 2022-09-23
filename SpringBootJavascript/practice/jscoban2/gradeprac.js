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
