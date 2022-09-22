function calculateFactorial(num) {
    let fact = 1;
    for (let x = 1; x <= num; x = x + 1) {
        fact = fact * x;
    }
    return fact;
}

console.log(calculateFactorial(5));
