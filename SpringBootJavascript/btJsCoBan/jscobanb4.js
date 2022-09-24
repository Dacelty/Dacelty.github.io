function subString(str) {
    let newString = "";
    for (let x = 0; x <= 12; x++) {
        if (x <= 9) {
            newString += str[x];
        } else {
            newString += ".";
        }

    }
    return newString;
}

console.log(subString('xinchaocacbandenvoiTechmaster'));