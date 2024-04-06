"use strict";
/* -- Typescript crash course -- */
// Basic types
let id = 5;
let company = "testing";
let isLoggedIn = true;
let anyValue = "testing";
anyValue = true;
let age = 19;
// Types in arrays
let arrayOfNumber = [1, 2, 3, 4, 5];
arrayOfNumber.push(6);
let arrayOfAny = [true, 1, "Sergio", 100, false];
// Tuple - Indicated for array with indexed multiple types
let person = [1, "sergio", false];
let employee;
employee = [
    [1, "Football"],
    [2, "Basketball"],
    [3, "Tenis"],
    [4, "Voleyball"],
    [5, "Racing"]
];
// Union
let values = 1;
values = "bread";
// Enum
var errors;
(function (errors) {
    errors[errors["ErrorLogging"] = -101] = "ErrorLogging";
    errors[errors["ErrorOfInternet"] = -100] = "ErrorOfInternet";
    errors[errors["ErrorOnPassword"] = -99] = "ErrorOnPassword";
    errors[errors["ErrorOnEmail"] = -98] = "ErrorOnEmail";
    errors[errors["ErrorOnProduct"] = -97] = "ErrorOnProduct";
})(errors || (errors = {}));
var errors2;
(function (errors2) {
    errors2["ErrorLogging"] = "Error in Logging on the website";
    errors2["ErrorOfInternet"] = "Error on the internet";
    errors2["ErrorOnPassword"] = "Error on typing the password";
    errors2["ErrorOnEmail"] = "Error on typing the email";
    errors2["ErrorOnProduct"] = "Error on selecting the product";
})(errors2 || (errors2 = {}));
const listOfUsers = {
    id: 1,
    name: "Sergio",
    age: 19,
    listOfProducts: ["Notebook", "Smartphone", "Videogame"]
};
// Type assertion
let userid = 1;
let listOfUserIds = userid;
// Funcitions
function addNumbers(x, y) {
    return x + y;
}
// console.log(addNumbers(2, 3))
const printMessage = (message) => {
    console.log(message);
};
const salmon = {
    id: 1,
    name: "Salmon",
    color: "Dark gray",
};
const sumNumbers = (x, y) => x + y;
const subNumbers = (k, j) => k + j;
class Person {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
    register() {
        return `${this.name} is now registered!`;
    }
}
const sergio = new Person(1, "Sergio");
console.log(sergio.register());
//Inheritance and subclasses
class Employee extends Person {
    constructor(id, name, nameOfCompany, position) {
        super(id, name);
        this.company = nameOfCompany;
        this.position = position;
    }
}
const mark = new Employee(2, "Mark", "Meta/Facebook", "Founder of the Company");
console.log(mark.register());
//Generics
function getArray(values) {
    return new Array().concat(values);
}
let numArray = getArray([1, 2, 3, 4, 5]);
let strArray = getArray(["Breakfast", "Lunch", "Dinner"]);
