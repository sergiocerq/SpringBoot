/* -- Typescript crash course -- */

// Basic types
let id: number = 5
let company: string = "testing"
let isLoggedIn: boolean = true
let anyValue: any = "testing"
anyValue = true
let age = 19

// Types in arrays
let arrayOfNumber: number[] = [1,2,3,4,5]
arrayOfNumber.push(6)

let arrayOfAny: any[] = [true, 1, "Sergio", 100, false]

// Tuple - Indicated for array with indexed multiple types
let person: [number, string, boolean] = [1, "sergio", false]
let employee: [number, string][]
employee = [
    [1, "Football"],
    [2, "Basketball"],
    [3, "Tenis"],
    [4, "Voleyball"],
    [5, "Racing"]
]

// Union
let values: string | number = 1
values = "bread"

// Enum
enum errors {
    ErrorLogging = -101,
    ErrorOfInternet,
    ErrorOnPassword,
    ErrorOnEmail,
    ErrorOnProduct,
}

enum errors2 {
    ErrorLogging = "Error in Logging on the website",
    ErrorOfInternet = "Error on the internet",
    ErrorOnPassword = "Error on typing the password",
    ErrorOnEmail = "Error on typing the email",
    ErrorOnProduct = "Error on selecting the product",
}

// console.log(errors2.ErrorOfInternet);

// Objects
type User = {
    id: number,
    name: string,
    age: number,
    listOfProducts: string[],
}

const listOfUsers: User = {
    id: 1,
    name: "Sergio",
    age: 19,
    listOfProducts: ["Notebook", "Smartphone", "Videogame"]
}

// Type assertion
let userid: any = 1;
let listOfUserIds = userid as number;

// Funcitions
function addNumbers(x: number, y: number): number {
    return x + y ;
}
// console.log(addNumbers(2, 3))

const printMessage = (message: string | number): void => {
    console.log(message)
}
// printMessage("Hello world! I´m testing the funcions on typescript!")

// Interfaces
interface fish {
    readonly id: number,
    name: string,
    color: string,
    isPoisonous?: boolean,
}

const salmon: fish = {
    id: 1,
    name: "Salmon",
    color: "Dark gray",
}

interface MathFuncion {
    (x: number, y: number): number
}

const sumNumbers: MathFuncion = (x: number, y: number): number => x + y;
const subNumbers: MathFuncion = (k: number, j: number): number => k + j;

// Classes
interface PersonInterface {
    id: number,
    name: string,
    register(): string
}

class Person implements PersonInterface {
    id: number
    name: string

    constructor(id: number, name: string) {
        this.id = id
        this.name = name
    }

    public register(): string {
        return `${this.name} is now registered!`;
    }
}

const sergio = new Person(1, "Sergio")
console.log(sergio.register())

//Inheritance and subclasses
class Employee extends Person {
    company: string
    position: string

    constructor(id: number, name: string, nameOfCompany: string, position: string) {
        super(id, name)
        this.company = nameOfCompany
        this.position = position
    }
}

const mark = new Employee(2, "Mark", "Meta/Facebook", "Founder of the Company")
console.log(mark.register())

//Generics
function getArray <T>(values: T[]): T[] {
    return new Array().concat(values);
}

let numArray = getArray([1,2,3,4,5])
let strArray = getArray(["Breakfast", "Lunch", "Dinner"])