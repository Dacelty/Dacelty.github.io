function getRandomArbitrary(min, max) {
    let step1 = max - min + 1;
    let step2 = Math.random()*step1;
    let result = Math.floor(step2) + min;
    return result;
}

function rps(){
    let human = getRandomArbitrary(1,3);
    let cpu = getRandomArbitrary(1,3);
    //1 = búa, 2 = kéo, 3 = bao
    switch (human){
        case 1:
            if (cpu == 1){
                console.log("Người chơi ra búa, máy tính ra búa");
                console.log("Kết quả : hòa.");
                break;
            }
            if (cpu == 2){
                console.log("Người chơi ra búa, máy tính ra kéo");
                console.log("Kết quả : người chơi thắng.");
                break;
            }
            if (cpu == 3){
                console.log("Người chơi ra búa, máy tính ra bao");
                console.log("Kết quả : người chơi thua.");
                break;
            }
        case 2:
            if (cpu == 1){
                console.log("Người chơi ra kéo, máy tính ra búa");
                console.log("Kết quả : người chơi thua.");
                break;
            }
            if (cpu == 2){
                console.log("Người chơi ra kéo, máy tính ra kéo");
                console.log("Kết quả : hòa.");
                break;
            }
            if (cpu == 3){
                console.log("Người chơi ra kéo, máy tính ra bao");
                console.log("Kết quả : người chơi thắng.");
                break;
            }
        case 3:
            if (cpu == 1){
                console.log("Người chơi ra bao, máy tính ra búa");
                console.log("Kết quả : người chơi thắng.");
                break;
            }
            if (cpu == 2){
                console.log("Người chơi ra bao, máy tính ra kéo");
                console.log("Kết quả : người chơi thua.");
                break;
            }
            if (cpu == 3){
                console.log("Người chơi ra bao, máy tính ra bao");
                console.log("Kết quả : hòa.");
                break;
            }
    }
}

console.log(rps());


