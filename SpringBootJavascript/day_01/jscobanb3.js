function translate(country) {
    switch (country) {
        case 'VN': {
            console.log("Xin chào");
            break;
        }
        case 'EN': {
            console.log("Hello");
            break;
        }
        case 'JP': {
            console.log("こんにちは");
            break;
        }
        case 'DE': {
            console.log("Hallo");
            break;
        }
        default: {
            console.log("Mã quốc gia không phù hợp");
            break;
        }
    }
}

console.log(translate('VN'));