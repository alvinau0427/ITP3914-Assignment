# ITP3914-Assignment
> IVE 2015/16 Programming (ITP3914) Assignment

> Java Program: MasterMind

## Getting Started
1. Make sure you understand how to play the Mastermind game. For simplicity, we use the numeric digit to represent that color `(i.e. 1 - "Blue", 2 - "Green", 3 - "Orange", 4 - "Purple", 5 - "Red", 6 - "Yellow")`.
2. Player 1 or Computer will set secret pattern and Player 2 tries to guess the pattern, in both order and color, within ten turns.
3. Each guess is made by placing a row of code pegs on the decoding board. Once placed, Player 1 provides feedback by placing from zero to four key pegs in the small holes of the row with the guess. A black key peg is placed for each code peg from the guess which is correct in both color and position. A white peg indicates the existence of a correct color peg placed in the wrong position.
4. The program including two mode: `Computer VS Player` or `Player 1 VS Player 2`

## Installation

### Setup
```
$ javac MasterMind.java
```

### Run the program
```
$ java MasterMind
```

## Demonstration
![image](https://github.com/alvinau0427/ITP3914-Assignment/blob/master/doc/demo.gif)

[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger)
[![Coverage Status](http://img.shields.io/coveralls/badges/badgerbadgerbadger.svg?style=flat-square)](https://coveralls.io/r/badges/badgerbadgerbadger)
[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)
