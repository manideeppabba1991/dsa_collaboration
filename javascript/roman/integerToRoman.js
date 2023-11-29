function integerToRoman(num) {
    const numerals = {
      M: 1000,
      CM: 900,
      D: 500,
      CD: 400,
      C: 100,
      XC: 90,
      L: 50,
      XL: 40,
      X: 10,
      IX: 9,
      V: 5,
      IV: 4,
      I: 1
    };
  
    let result = '';
  
    for (let key in numerals) {
      while (num >= numerals[key]) {
        result += key;
        num -= numerals[key];
      }
    }
  
    return result;
  }

  // print results

  const printResult = (arr) => {
    arr.forEach((num, i) => console.log(integerToRoman(num)));
  }

  printResult([45, 467, 3420, 3567]);