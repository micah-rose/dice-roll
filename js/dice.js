//TO DO's:
//Create function for roll button
//Create function for reset button

var dice1 = 0;
var dice2 = 0;
var dice3 = 0;
var dice4 = 0;
var dice5 = 0;
var dice6 = 0;
var rand;
var checkbox;

function rollDie() {
  var numRoll = document.getElementById("die-batch").value;
  checkbox = document.getElementById("chkbx");
  rand = Math.ceil(Math.random() * 6);

  console.log("Die have been rolled");

  if (checkbox.checked) {
    for (i = 0; i < numRoll; i++) {
      rand = Math.ceil(Math.random() * 6);

      if (rand == 1) {
        dice1++;
      }
      if (rand == 2) {
        dice2++;
      }
      if (rand == 3) {
        dice3++;
      }
      if (rand == 4) {
        dice4++;
      }
      if (rand == 5) {
        dice5++;
      }
      if (rand == 6) {
        dice6++;
      }
    }
    document.getElementById("ones-box").value = dice1;
    document.getElementById("twos-box").value = dice2;
    document.getElementById("threes-box").value = dice3;
    document.getElementById("fours-box").value = dice4;
    document.getElementById("fives-box").value = dice5;
    document.getElementById("sixes-box").value = dice6;

    dice1 = 0;
    dice2 = 0;
    dice3 = 0;
    dice4 = 0;
    dice5 = 0;
    dice6 = 0;
  } else {
    if (rand == 1) {
      dice1++;
      document.getElementById("dice-image").src = "img/die-black-1.png";
      document.getElementById("ones-box").value = dice1;
    }
    if (rand == 2) {
      dice2++;
      document.getElementById("dice-image").src = "img/die-black-2.png";
      document.getElementById("twos-box").value = dice2;
    }
    if (rand == 3) {
      dice3++;
      document.getElementById("dice-image").src = "img/die-black-3.png";
      document.getElementById("threes-box").value = dice3;
    }
    if (rand == 4) {
      dice4++;
      document.getElementById("dice-image").src = "img/die-black-4.png";
      document.getElementById("fours-box").value = dice4;
    }
    if (rand == 5) {
      dice5++;
      document.getElementById("dice-image").src = "img/die-black-5.png";
      document.getElementById("fives-box").value = dice5;
    }
    if (rand == 6) {
      dice6++;
      document.getElementById("dice-image").src = "img/die-black-6.png";
      document.getElementById("sixes-box").value = dice6;
    }
  }
}

function resetRolls() {
  console.log("Die have been reset");
  document.getElementById("die-batch").readOnly = true;
  document.getElementById("dice-image").src = "img/bunch-of-dice.png";
  document.getElementById("ones-box").value = "";
  document.getElementById("twos-box").value = "";
  document.getElementById("threes-box").value = "";
  document.getElementById("fours-box").value = "";
  document.getElementById("fives-box").value = "";
  document.getElementById("sixes-box").value = "";
  document.getElementById("chkbx").checked = false;
  document.getElementById("die-batch").value = "100";

  dice1 = 0;
  dice2 = 0;
  dice3 = 0;
  dice4 = 0;
  dice5 = 0;
  dice6 = 0;
}

function dieBatch() {
  checkbox = document.getElementById("chkbx");
  if (checkbox.checked) {
    document.getElementById("die-batch").readOnly = false;
    console.log("Batch box has been checked");
  } else {
    document.getElementById("die-batch").readOnly = true;
    console.log("Batch box has been unchecked");
  }
}
