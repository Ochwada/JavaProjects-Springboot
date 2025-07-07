// --------------------------------------------------
// Create collection and Insert dummy user
// --------------------------------------------------
// customer
db.customers.insertMany([
  {
    name: "Alice",
    email: "alice@example.com",
    age: 28,
    status: "active",
    addresses: [
      { city: "New York", zip: "10001" },
      { city: "Boston", zip: "02101" }
    ]
  },
  {
    name: "Bob",
    email: "bob@example.com",
    age: 35,
    status: "inactive",
    addresses: [
      { city: "Chicago", zip: "60601" }
    ]
  },
  {
    name: "Carol",
    email: "carol@example.com",
    age: 22,
    status: "active",
    addresses: []
  },
  {
    name: "Dave",
    email: "dave@example.com",
    age: 40,
    status: "active",
    addresses: [
      { city: "San Francisco", zip: "94101" },
      { city: "Seattle", zip: "98101" }
    ]
  }
])
// products
db.products.insertMany([
  {
    name: "Laptop",
    category: "Electronics",
    price: 1200,
    tags: ["electronics", "computer"]
  },
  {
    name: "Smartphone",
    category: "Electronics",
    price: 800,
    tags: ["electronics", "mobile"]
  },
  {
    name: "Coffee Mug",
    category: "Kitchen",
    price: 20,
    tags: ["kitchen", "ceramic"]
  },
  {
    name: "Blender",
    category: "Kitchen",
    price: 150,
    tags: ["kitchen", "appliance"]
  },
  {
    name: "Headphones",
    category: "Electronics",
    price: 250,
    tags: ["electronics", "audio"]
  }
])

// --------------------------------------------------
//  1. Find products with price less than 1000
// --------------------------------------------------
db.products.find({price : {$lt: 1000}})

// --------------------------------------------------
//  2. Find products with price between 100 and 1000 (inclusive)
// --------------------------------------------------
db.products.find({ price : {$gte: 100, $lte: 1000}})

// --------------------------------------------------
//  3. Find products in either "Electronics" or "Kitchen" category
// --------------------------------------------------
db.products.find( { category: {$in: ["Electronics", "Kitchen"]}})

/*
// 4. Find customers who are either active OR younger than 30

print("Customers who are either 'active' or under 30:");
db.customers.find({
  $or: [
    { status: "active" },
    { age: { $lt: 30 } }
  ]
}).forEach(printjson); 

print("\nCustomers who are active AND under 30:");
db.customers.find({
  $and: [
    { status: "active" },
    { age: { $lt: 30 } }
  ]
}).forEach(printjson);
mongosh < queries.js

*/
// --------------------------------------------------
// 4. Find customers who are either "active" OR younger than 30
// --------------------------------------------------
db.customers.find({
  $or: [
    { status: "active" },
    { age: { $lt: 30 } }
  ]
})

// --------------------------------------------------
// 5. Find customers who are "active" AND younger than 30
// --------------------------------------------------
db.customers.find({
  $and: [
    { status: "active" },
    { age: { $lt: 30 } }
  ]
})

// --------------------------------------------------
// 5. Field exists
// --------------------------------------------------
// Field exists (even if null)
db.customers.find({ addresses: { $exists: true } })

// Field exists and is NOT null
db.customers.find({ addresses: { $exists: true, $ne: null } })


// --------------------------------------------------
// 6. Field does not exists
// --------------------------------------------------
db.customers.find(
 {
   addresses: {$exists: false}
 }
)

// --------------------------------------------------
// 7. Add Data to User collection (table in SQL)
// --------------------------------------------------