function getElementGreater (arr, num) {
    let arr2 = [];
    for( let i = 0; i < arr.length; i++){ 
        if ( arr[i] > num) { 
            arr2.push(arr[i]);
        }
    }
    return arr2;
}

console.log(getElementGreater([1,2,3,4,5], 3));