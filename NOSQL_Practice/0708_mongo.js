/*
================================================================================
MongoDB Script Documentation
================================================================================

Author: Linda Ochwada
Date: 2025-07-08
Database: MongoDB
Environment: JavaScript Shell (e.g., MongoDB Compass, mongosh)
Description:
This script performs three main database operations:
1. Updates a user's email based on their name.
2. Checks the current read concern level for the MongoDB client.
3. Inserts a new vehicle record into the `vehicles` collection with specific data.

--------------------------------------------------------------------------------
1. Update User Email by Name
--------------------------------------------------------------------------------

Operation:
  Update the `email` field of a user where the `name` is "Linda Doe".

Command:
*/
  db.users.update(
    { name: "Linda Doe" },
    { $set: { email: "lin@gmx.de" } }
  )
/*
Explanation:
  - Finds the first document in the `users` collection with the exact name "Linda Doe".
  - Sets the `email` field to "lin@gmx.de".
  - `update()` modifies only the first matched document by default.

⚠️ Note:
  - `update()` is **deprecated** in modern MongoDB versions.
  - Use `updateOne()` for better clarity and forward compatibility:
    db.users.updateOne(
      { name: "Linda Doe" },
      { $set: { email: "lin@gmx.de" } }
    )

--------------------------------------------------------------------------------
2. Read Concern Check (Get the Current Read Concern)
--------------------------------------------------------------------------------

Operation: 
*/
  db.getMongo().getReadConcern()

/*
Explanation:
  - Retrieves the current **read concern level** for the MongoDB client.
  - Read concern defines the level of consistency and isolation for read operations.
  - Common levels include:
    • "local" — returns data from the node regardless of replication state.
    • "majority" — returns data acknowledged by the majority of replica set members.
    • "linearizable" — ensures strictest consistency but with performance cost.

--------------------------------------------------------------------------------
3. Insert Vehicle Record
--------------------------------------------------------------------------------

Operation:
*/
  db.vehicles.insertOne(
    {
      vehicleId: "V-1500",
      driver: "Phil",
      location: { lat: 25.7617, lon: -81.1918 },
      status: "active",
      fuelLevel: 50,
      lastUpdated: new Date()
    },
    { writeConcern: { w: "majority" } }
  )
/*
Explanation:
  - Inserts a new document into the `vehicles` collection.
  - Fields include:
    • vehicleId — Unique identifier for the vehicle.
    • driver — Driver’s name.
    • location — GPS coordinates (latitude and longitude).
    • status — Operational status (e.g., "active").
    • fuelLevel — Current fuel level as a percentage.
    • lastUpdated — Timestamp when the data was last recorded.
  - Ensures write durability with:
    • writeConcern: { w: "majority" }, meaning the data must be written to
      a majority of replica set members before the operation is acknowledged.

      | Concern Type      | Purpose                  | Command Example                                      |
| ----------------- | ------------------------ | ---------------------------------------------------- |
| **Write Concern** | Ensures safe writes      | `writeConcern: { w: "majority" }`                    |
| **Read Concern**  | Ensures consistent reads | `readConcern: { level: "majority" }` (used in reads) |


================================================================================
*/
