
// --------------------------------------------------
// RESET ALL COLLECTIONS / DELETE
// Equivalent to: DROP TABLE IF EXISTS ... CASCADE
// --------------------------------------------------
// Defensive drop
if (db.getCollectionNames().includes("customers")) db.customers.drop();
if (db.getCollectionNames().includes("products")) db.products.drop();
if (db.getCollectionNames().includes("users")) db.users.drop();
/*
db.customers.drop();
db.products.drop();
db.users.drop();
*/
/*
Explanation:
- This deletes the entire collection and all its documents.
- Unlike SQL, there are no foreign key constraints, so no need for CASCADE.
- If a collection does not exist, `drop()` simply does nothing.
- You can wrap this in a script and run it before seeding your database.
*/

// Optional: Check if dropped
print("Collections dropped (if they existed): customers, products, users");

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
db.products.find({ price: { $lt: 1000 } })

// --------------------------------------------------
//  2. Find products with price between 100 and 1000 (inclusive)
// --------------------------------------------------
db.products.find({ price: { $gte: 100, $lte: 1000 } })

// --------------------------------------------------
//  3. Find products in either "Electronics" or "Kitchen" category
// --------------------------------------------------
db.products.find({ category: { $in: ["Electronics", "Kitchen"] } })

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
    addresses: { $exists: false }
  }
)

// --------------------------------------------------
// 7. Add Data to User collection (table in SQL)
// --------------------------------------------------

// users
db.users.insertOne(
  {
    name: "Linda Doe",
    email: "linda@gmx.de",
    createdAt: ISODate(),
    status: "Active"
  }
)

db.users.insertMany([
  {
    name: "Linda Doe",
    email: "linda@gmx.de",
    createdAt: ISODate(),
    status: "Active"
  },
  {
    name: "John Smith",
    email: "john.smith@example.com",
    createdAt: ISODate(),
    status: "Inactive"
  },
  {
    name: "Emily Zhang",
    email: "emily.zhang@example.org",
    createdAt: ISODate(),
    status: "Active"
  },
  {
    name: "Carlos Mendez",
    email: "carlos.mendez@example.com",
    createdAt: ISODate(),
    status: "Pending"
  },
  {
    name: "Aisha Abdi",
    email: "aisha.abdi@example.net",
    createdAt: ISODate(),
    status: "Active"
  }
])

// --------------------------------------------------
// 8A. Find users where the "name" exactly matches "Linda Doe"
// (case-sensitive exact match)
// --------------------------------------------------

db.users.find({
  "name": "Linda Doe"
})

db.users.find({
  name: "Linda Doe"
})
/*
Expected result:
{
  _id: ObjectId('686ba1895752b1e44945d890'),
  name: 'Linda Doe',
  email: 'linda@gmx.de',
  createdAt: ISODate("2025-07-07T10:29:29.045Z"),
  status: 'Active'
}
*/

// Optional: nicely print results if running in script
// db.users.find({ name: "Linda Doe" }).forEach(printjson)


// --------------------------------------------------
// 8B. Case-Insensitive Match on Name
// (matches "linda doe", "LINDA DOE", etc.)
// --------------------------------------------------
db.users.find({
  name: { $regex: /^linda doe$/i }
})


// --------------------------------------------------
// 8C. Find user by email
// (precise, preferred method for unique user lookup)
// --------------------------------------------------
db.users.findOne(
  {
    email: "linda@gmx.de"
  }
)

// --------------------------------------------------
// 9A. Sort users by name in descending order (Z → A)
// --------------------------------------------------
/*
Explanation:
- Retrieves all documents in the 'users' collection
- Sorts them by the 'name' field in descending order
- Equivalent to ORDER BY name DESC in SQL
*/
db.users.find().sort({ name: -1 })

// --------------------------------------------------
// 8B. Sort users by name in ascending order (A → Z)
// --------------------------------------------------
/*
Explanation:
- Retrieves all documents in the 'users' collection
- Sorts them by the 'name' field in ascending order
- Equivalent to ORDER BY name ASC in SQL
*/
db.users.find().sort({ name: 1 })

// --------------------------------------------------
// 9A. First 3 users by name in ascending order (A → Z)
// Equivalent to: ORDER BY name ASC LIMIT 3
// --------------------------------------------------
db.users.find().sort(
  { name: 1 }
).limit(3)
/*
Expected output:
- The 3 users whose names come first alphabetically
- Useful for paginated user listings or previews
*/

// --------------------------------------------------
// 9B. Last 3 users by name in descending order (Z → A)
// Equivalent to: ORDER BY name DESC LIMIT 3
// --------------------------------------------------
db.users.find().sort(
  { name: -1 }
).limit(3)

/*
Expected output:
- The 3 users whose names come last alphabetically
- Useful for reverse-sorted lists or audits
*/

// --------------------------------------------------
// 10A. Estimate total number of documents in 'users' collection
// --------------------------------------------------

db.users.estimatedDocumentCount()

/*
Explanation:
- Returns a fast, approximate count of all documents in the collection.
- Uses collection metadata (does not scan documents).
- Does NOT support filtering.
- Best for quick metrics or dashboard overviews.
*/


// --------------------------------------------------
// 10B. Get exact document count (scans collection)
// --------------------------------------------------

db.users.countDocuments()

/*
Explanation:
- Returns an accurate count of all documents.
- Slower than estimatedDocumentCount() on large datasets.
- Supports query filters.
*/


// --------------------------------------------------
// 10C. Count only users with status "Active"
// (case-sensitive)
// --------------------------------------------------

db.users.countDocuments({
  status: "Active"
})

/*
Note:
- This query matches only exact case "Active"
- Will NOT match "active", "ACTIVE", etc.
*/


// --------------------------------------------------
// 11A. Find users whose status is NOT exactly "Active" (case-sensitive)
// --------------------------------------------------

db.users.find({
  status: { $ne: "Active" }
})

/*
Note:
- This excludes only documents where status is exactly "Active"
- It is case-sensitive: will still include "active", "ACTIVE", etc.
*/


// --------------------------------------------------
// 11B. Case-insensitive: Find users whose status is not "active"
// --------------------------------------------------

db.users.find({
  status: { $not: /^active$/i }
})

/*
Explanation:
- Uses regex with ^ and $ to match exact value "active"
- The 'i' flag makes it case-insensitive
- $not negates the match, so it returns users with any other status
- More robust if your data has inconsistent casing (e.g., "Active", "ACTIVE")
*/

// --------------------------------------------------
// 12. Update a user's email by name
// --------------------------------------------------
db.users.update(
  {
    name: "Linda Doe"
  },
  {
    $set: {email : "lin@gmx.de" } 
  }
)
/*
Explanation:
- Finds the first document where `name` is exactly "Linda Doe"
- Updates the `email` field to "lin@gmx.de"
- Only updates **one** document by default

Note:
- `update()` is now deprecated in favor of `updateOne()` or `updateMany()`
- Consider using `updateOne()` for clarity and forward compatibility
*/ 

db.getMongo().getReadConcern()

db.vehicles.insertOne(
  {
    vehicleId: "V-1400",
    driver: "Linda",
    location: { lat: 25.7617, lon: -81.1918 },
    status: "active",
    fuelLevel: 50,
    lastUpdated: new Date()
  },
  { writeConcern: { w: "majority" } }
)
