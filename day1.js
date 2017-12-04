input = require("fs").readFileSync("./day1.txt");

// Look at the input
input.toString().trim();

// Parse
// prettier-ignore
var numbers = input.toString().trim().split('').map(Number)

//
// Star 1
//

// Walk the input with reduce
var thing = numbers.reduce(
  ({ last, out }, v) => ({ last: v, out: out + (last === v ? v : 0) }),
  { last: numbers[numbers.length - 1], out: 0 }
);
thing.out;
1031; // <------------------------------------------------------------------------------------------
console.log("Star 1:", thing.out);

//
// Star 2
//

var half = numbers.length / 2;
var out = 0;
for (let i = 0; i < half; i++) {
  if (numbers[i] === numbers[i + half]) {
    out += numbers[i];
  }
}
out * 2;
1080; // <------------------------------------------------------------------------------------------
console.log("Star 2:", out * 2);
