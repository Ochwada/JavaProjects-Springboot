/*
================================================================================
MongoDB Script Documentation
================================================================================

Author: Linda Ochwada
Date: 2025-07-08, Tuesday
Database: MongoDB
Environment: JavaScript Shell (e.g., MongoDB Compass, mongosh)
Description: Advanced MongoDB Queries Practice Guide
*/

/* ----------------------------------------------------
1. DATABASE SETUP
------------------------------------------------------*/
/* 
Switch / Create Database
*/
// use libraryDB 

/* ----------------------------------------------------
2.  INSERT SAMPLE DATA
------------------------------------------------------*/
/* 
2(a). Create and insert sample data into collection (table) - books
*/
db.books.insertMany([
    { title: "Clean Code", author: "Robert C. Martin", category: "Programming", price: 45, tags: ["code", "best-practice"], available: true },
    { title: "Design Patterns", author: "GoF", category: "Programming", price: 55, tags: ["architecture", "classic"], available: true },
    { title: "Harry Potter", author: "J.K. Rowling", category: "Fantasy", price: 30, tags: ["magic", "bestseller"], available: false },
    { title: "The Hobbit", author: "J.R.R. Tolkien", category: "Fantasy", price: 28, tags: ["classic", "adventure"], available: true },
    { title: "Data Science Handbook", author: "Jake VanderPlas", category: "Data", price: 60, tags: ["data", "science"], available: true },
    { title: "Eloquent JavaScript", author: "Marijn Haverbeke", category: "Programming", price: 35, tags: ["javascript", "web"], available: false },
    { title: "Algorithms", author: "Sedgewick", category: "Programming", price: 70, tags: ["algorithms", "classic"], available: true },
    { title: "Lord of the Rings", author: "J.R.R. Tolkien", category: "Fantasy", price: 50, tags: ["epic", "adventure"], available: false },
    { title: "Python Crash Course", author: "Eric Matthes", category: "Programming", price: 40, tags: ["python", "beginner"], available: true },
    { title: "Deep Learning", author: "Goodfellow", category: "AI", price: 80, tags: ["ai", "ml"], available: true },
    { title: "The Silmarillion", author: "J.R.R. Tolkien", category: "Fantasy", price: 35, tags: ["epic", "lore"], available: true },
    { title: "AI Superpowers", author: "Kai-Fu Lee", category: "AI", price: 45, tags: ["ai", "china"], available: true },
    { title: "The Pragmatic Programmer", author: "Andrew Hunt", category: "Programming", price: 50, tags: ["best-practice", "career"], available: true },
    { title: "Kafka on the Shore", author: "Haruki Murakami", category: "Fiction", price: 25, tags: ["magic", "modern"], available: true }
])

/* 
2(b). Create and insert sample data into collection (table) - members
*/
db.members.insertMany([
    { name: "Alice", email: "alice@example.com", age: 24, status: "active", addresses: [{ city: "New York", zip: "10001" }] },
    { name: "Bob", email: "bob@example.com", age: 35, status: "inactive", addresses: [{ city: "Chicago", zip: "60601" }] },
    { name: "Carol", email: "carol@example.com", age: 28, status: "active", addresses: [{ city: "Boston", zip: "02101" }] },
    { name: "Dave", email: "dave@example.com", age: 40, status: "active", addresses: [{ city: "San Francisco", zip: "94101" }, { city: "Seattle", zip: "98101" }] },
    { name: "Eve", email: "eve@example.com", age: 22, status: "active", addresses: [] },
    { name: "Frank", email: "frank@example.com", age: 30, status: "inactive", addresses: [{ city: "Los Angeles", zip: "90001" }] },
    { name: "Grace", email: "grace@example.com", age: 27, status: "active", addresses: [{ city: "Austin", zip: "73301" }] },
    { name: "Heidi", email: "heidi@example.com", age: 32, status: "active", addresses: [{ city: "Denver", zip: "80201" }] },
    { name: "Ivan", email: "ivan@example.com", age: 45, status: "inactive", addresses: [{ city: "Miami", zip: "33101" }] },
    { name: "Judy", email: "judy@example.com", age: 29, status: "active", addresses: [{ city: "Philadelphia", zip: "19101" }] }
])

/* 
2(c). Create and insert sample data into collection (table) - borrowedRecords
*/
db.borrowRecords.insertMany([
    { memberId: "Alice", bookTitle: "Clean Code", borrowDate: ISODate("2024-06-01"), returnDate: null, status: "borrowed" },
    { memberId: "Bob", bookTitle: "Harry Potter", borrowDate: ISODate("2024-05-15"), returnDate: ISODate("2024-06-10"), status: "returned" },
    { memberId: "Carol", bookTitle: "Design Patterns", borrowDate: ISODate("2024-06-05"), returnDate: null, status: "borrowed" },
    { memberId: "Dave", bookTitle: "Lord of the Rings", borrowDate: ISODate("2024-05-20"), returnDate: ISODate("2024-06-15"), status: "returned" },
    { memberId: "Eve", bookTitle: "Deep Learning", borrowDate: ISODate("2024-06-10"), returnDate: null, status: "borrowed" },
    { memberId: "Frank", bookTitle: "Harry Potter", borrowDate: ISODate("2024-06-01"), returnDate: null, status: "borrowed" },
    { memberId: "Grace", bookTitle: "The Hobbit", borrowDate: ISODate("2024-06-12"), returnDate: null, status: "borrowed" },
    { memberId: "Heidi", bookTitle: "Algorithms", borrowDate: ISODate("2024-06-02"), returnDate: ISODate("2024-06-20"), status: "returned" },
    { memberId: "Ivan", bookTitle: "AI Superpowers", borrowDate: ISODate("2024-06-15"), returnDate: null, status: "borrowed" },
    { memberId: "Judy", bookTitle: "Eloquent JavaScript", borrowDate: ISODate("2024-06-05"), returnDate: null, status: "borrowed" }
])

/* 
2(d). Create and insert sample data into collection (table) - staff
*/
db.staff.insertMany([
    { name: "Manager Mike", role: "Manager", age: 45, employed: true },
    { name: "Librarian Laura", role: "Librarian", age: 32, employed: true },
    { name: "Assistant Alex", role: "Assistant", age: 24, employed: true },
    { name: "Technician Tom", role: "Technician", age: 38, employed: false },
    { name: "Clerk Cathy", role: "Clerk", age: 29, employed: true },
    { name: "Intern Ian", role: "Intern", age: 21, employed: true }
])

/* ----------------------------------------------------
3.  PRACTICE: ADVANCED QUERIES
------------------------------------------------------*/
// -------------- a. Comparison Operators

/* --
    i. Find all books cheaper than $40.
    Explanation: Finds books with price less than 40.
-- */
db.books.find({
    price: { $lt: 40 }
}).pretty()


/* --
    ii. Find books priced between $30 and $60 inclusive.
     Explanation: $gte (≥) and $lte (≤) combined to define a price range.
-- */

db.books.find({
    price : {$gte : 30 , $lte: 60}
}).pretty()

// -------------- b.  $in and $nin
/* --
    iii. Find books in categories Programming or AI.
    Explanation: $in matches any value in the given array.
-- */
db.books.find({
    category: {
        $in: ["Programming", "AI"]
    }
})
/* --iv. Exclude books in Fantasy category.
     Explanation: $nin excludes any of these categories.
-- */
db.books.find({
    category: { $nin : ["Fantasy"]}
})

// -------------- c. Logical Operators

/* --v.  Find active members or those younger than 25.
      Explanation: $or lets either condition match.
-- */
db.members.find({
    $or: [
        {age : {$lt: 25}},
        {status: "active"}
    ]
})

/* --vi.  Find active members older than 30.
    Explanation: $and requires both conditions.
-- */
db.members.find({
    $and: [
        {status : "active"},
        {age : {$gt: 30}}
    ]
})

/* --vii.   Find members who are NOT (active OR younger than 25).
     Explanation: $nor returns docs that match neither condition.
-- */

db.members.find({
  $nor: [
    { status: "active" },
    { age: { $lt: 25 } }
  ]
})

// -------------- d. $exists
/* --viii. Find members that have an addresses field.
      Explanation: Checks if the field is present.
-- */

db.members.find({
 addresses : { $exists: true}
})

// -------------- e. $type
/* -- ix. Find staff with age stored as int.
      Explanation: Verifies field data type.
-- */

db.staff.find({ 
    age: { $type: "int" } 
})

// -------------- f. $regex
/* -- x. Find books with 'JavaScript' in title (case-insensitive).
       Explanation: Pattern match ignoring case.
-- */

db.books.find({ 
    title: { 
        $regex: "javascript",
         $options: "i" 
        }
 })
 
/* -- xi. Find staff whose name starts with 'M'.
       Explanation: ^ anchors to the start.
-- */

db.staff.find({
     name: { $regex: "^M" } 
    })

// -------------- g. $all
/* -- xii. Find books with BOTH 'epic' and 'adventure' tags.
    Explanation: $all requires all values in array.
-- */
db.books.find({
     tags: 
     { $all: ["epic", "adventure"] } 
    })

// -------------- h. $all
/* -- xiii. Find members with an address in New York.
   Explanation: Matches documents where any element in addresses array matches.
-- */
db.members.find({
  addresses: 
    { $elemMatch: 
        { city: "New York" } 
    }
})

// -------------- i. $size
/* -- xiv.  Find members with exactly 2 addresses.
   Explanation: Matches arrays of given length.
-- */
db.members.find({ 
    addresses: { $size: 2 } 
})

// -------------- j. $not
/* -- xv. Find staff who are NOT employed.
   Explanation: Negates the condition.
-- */
db.staff.find({ 
    employed: 
    { $not: { $eq: true } } 
})

// -------------- k. Sorting
/* --xvi. List all books by price descending.
    Explanation: -1 = descending order.
-- */
db.books.find().sort({ 
    price: -1 
})


// -------------- l.  Projection
/* --xvii. Show only title and price of books.
Explanation: Includes only specified fields.
-- */
db.books.find(
    {}, 
    {
         title: 1, 
         price: 1, 
         _id: 0 
    })

// -------------- m.  Aggregation: Group
/* --xviii. Count borrowRecords by status.
Explanation: Groups by status, counts.
-- */
db.borrowRecords.aggregate([
  { $group: { 
    _id: "$status", 
    count: { $sum: 1 } 
} }
])

// -------------- n.  Aggregation: Match + Project
/* --xix.  Show only Fantasy books with their title and price
Explanation: Filters, then reshapes fields.
-- */

db.books.aggregate([
  { $match: { category: "Fantasy" } },
  { $project: { title: 1, price: 1, _id: 0 } }
])

// -------------- o. Aggregation: Sort
/* --xx.  Sort staff by age ascending.
Explanation: 1 = ascending order.
-- */

db.staff.aggregate([
  { $sort: { age: 1 } }
])

// -------------- p.Aggregation: Complex Example
/* --xxi.  For Programming books, show average price.
Explanation: Filters to category, then groups and averages.
-- */

db.books.aggregate([
  { $match: { category: "Programming" } },
  { $group: { _id: "$category", 
    avgPrice: 
    { $avg: "$price" } 
} }
])

/* ----------------------------------------------------
4.  COMBO / ADVANCED CHALLENGES
------------------------------------------------------*/
// ---  Challenge 1 : Find active members older than 25 with at least 1 address.

db.members.find({
  $and: [
    { status: "active" },
    { age: { $gt: 25 } },
    { addresses: { $exists: true, $ne: [] } }
  ]
})

// ---   Challenge 2 :  Find books in Programming or AI categories priced below $50.
db.books.find({
  $and: [
    { category: { $in: ["Programming", "AI"] } },
    { price: { $lt: 50 } }
  ]
})


// ---  Challenge 3 : Count number of active vs inactive members.
db.members.aggregate([
  { $group: { _id: "$status", count: { $sum: 1 } } }
])


// ---  Challenge 4 : Find borrowRecords with null returnDate (currently borrowed).
db.borrowRecords.find({ returnDate: null })


// ---  Challenge 5 : Find books that are available and have both 'classic' and 'architecture' tags.
db.books.find({
  $and: [
    { available: true },
    { tags: { $all: ["classic", "architecture"] } }
  ]
})

/* ----------------------------------------------------
4.  BONUS STUDENT QUESTIONS
------------------------------------------------------*/

// --- Q1: How do you exclude unavailable books?
db.books.find({ 
    available: 
    { $eq: true } 
})

db.books.aggregate([
  { $match: { available:  { $eq: true } }},
  { $project: { title: 1, available: 1, author:1,  _id: 0 } }
])


// --- Q2: How would you find staff whose name contains "an" anywhere?
db.staff.find({ 
    name: { 
        $regex: "an", 
        $options: "i" 
    } })

// --- Q3: How do you find borrowRecords for a given member? (e.g., Alice)
db.borrowRecords.find({
     memberId: "Alice" 
    })

// --- Q4: How do you get the highest priced book?
db.books.find().sort({ 
    price: -1 
}).limit(1)

// --- Q5:  How to list members who don't have addresses field at all?

db.members.find({ 
    addresses: { $exists: false } 
})