# ITP3914-Assignment
> IVE 2015/16 Programming (ITP3914) Assignment

> Java Program: MasterMind

[![Build Status](https://travis-ci.com/alvinau0427/ITP3914-Assignment.svg?branch=master)](https://travis-ci.org/alvinau0427/ITP3914-Assignment)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

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

## Screenshots
![Image](https://github.com/alvinau0427/ITP3914-Assignment/blob/master/doc/demo.gif)

## License
- ITP3914-Assignment is released under the [MIT License](https://opensource.org/licenses/MIT).
```
Copyright (c) 2020 alvinau0427

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
