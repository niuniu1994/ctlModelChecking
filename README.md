
# CTL model checking
[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)


This project is intended as an important part of final year course “Formal Modeling and Verification of Critical Systems”, which should be done in form of two- or three-man group.
The publication date of project is January 3d 2022 and it should be submitted before February 6th, 2022.

Our group is composed of Daniel Guirol FOGUE TSAKOU and Kaining XIN, we have implemented a CTL (Computation tree logic) model checking application using language JAVA which takes a Kripke structure and a CTL formula as input, and our application allows users to check whether the system represented by Kripke structure satisfies the CTL formula.
The system is mainly built with module and each of them is responsible for  resolving one specific challenge : the antlr allows system to accept the input of CTL formula, verify the correctness of the input, and transform the input into a java bean; the kripke module allows system to read a kripke structure from a JSON file and transform it to the java bean; the ctl module is the core of the program that is responsible for checking if the kripke structure satisfy the CTL formula.



## Installation

PreRequisite
- gradle 7.3.3 or version superior
- jdk 17 or version superior


Install the projet with gradle and lance the program with java

```bash
    git clone https://github.com/niuniu1994/ctlModelChecking.git
    cd ctlModelChecking
    gradle jar
    java -jar build/libs/tp-model-check-ctl-1.0-SNAPSHOT.jar src/main/resources/kriple1.json  
```

The program takes a json file of kriple structure as input parameter, so please replace  **src/main/resources/kriple1.json** with your own json file.

## CTL syntax

Input format of CTL formula:
Our application allows users to input CTL formula from command line by following syntax:

- Atomic proposition: we only accept lowercase letters from ‘a’ to ‘z’
- Whitespace is tolerated but not recommended
- AX => AX(a) EX => EX(a)
- AG => AG(a) EG => EG(a)
- AF => AF(a) AF => AF(a)
- AU => A(aUb) EU => E(aUb)
- Not => ^
- AND => &&
- OR => ||
- IMPLY =>
- TRUE => true
- FALSE => false

More exemple:

- ^AX(a&&EX(a))
- E(trueU(a&&b))
- ...
