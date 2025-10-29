# Bookings CRUD API using Flask and MySQL

A simple Flask REST API to manage bookings with Create, Read, Update, and Delete operations using a MySQL database.

---

## Setup

### 1. Install Dependencies
```bash
pip install -r requirements.txt
```
### 2. Database Setup
```sql
mysql -u root -p
CREATE DATABASE bookings_db;
USE bookings_db;
Run SQL file:
```
```
mysql -u root -p bookings_db < bookings.sql
```
### 3. Run Flask App
```bash
python app1.py
```
```bash
Server runs at:
http://127.0.0.1:5000
```

### Testing with Postman
```bash
Open Postman → Import → Select postman_collection.json

Use endpoints:

GET /bookings – Get all bookings

GET /bookings/<id> – Get booking by ID

POST /bookings – Add booking

PUT /bookings/<id> – Update booking

DELETE /bookings/<id> – Delete booking

Set header:
Content-Type: application/json
```
### Example JSON:
```json
{
  "customer_name": "Anurag Pawar",
  "booking_date": "2025-10-28",
  "booking_time": "10:30",
  "total_amount": 1200,
  "status": "confirmed",
  "payment_method": "UPI",
  "duration_minutes": 45
}
```
