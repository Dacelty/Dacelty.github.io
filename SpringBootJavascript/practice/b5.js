function repeatString(str) {
    let newString2 = [];
    for (let x = 0; x <= 9; x++) {
        if (x == 0) {
            newString2.push(str)
        } else {
            newString2.push('-');
            newString2.push(str);
        }

    }
    let newString3 = newString2.join(" ");
    return newString3;
}
console.log(repeatString('ab'));