# Inventory and Sales System (JavaFX)

This is a desktop application built with Java and JavaFX that simulates a full inventory and sales system. The system is divided into admin and cashier interfaces, allowing product storage, cashier management, order processing, and financial reporting.

---

##  Tech Stack

- Java 8+  
- JavaFX (with FXML)  
- SQLite (`SAS.db`)  
- MVC-style architecture  

---

##  Core Features

###  Admin Module
- Admin login page (`AdminLogin.fxml`)
- Admin dashboard (`AdminMainPage.fxml`)
- Manage cashier accounts (`InsertCashers.fxml`)
- View storage and inventory status (`MainProjStorage.fxml`)
- Generate and view reports (`ReportInput.fxml`, `ReportShow.fxml`)

###  Cashier Module
- Cashier login and access screen (`CashierMainScreen.fxml`)
- Product selection and cart system
- Order summary page (`OrderSummary.fxml`)
- Payment method handling:
  - Cash (`PaymentMethodCash.fxml`)
  - Card (`PaymentMethodCard.fxml`)
- Real-time order and product handling

###  Inventory & Storage
- Add/edit/remove products in storage
- View storage table (`MainProjStorageController.java`, `StorageTableView.java`)
- Syncs directly with the database via JavaFX TableViews

###  Reports
- Admin can input filters to generate specific reports
- Display results using `TableView`
- Uses model classes like `Report.java`, `Order.java`, and `OrderSummaryController.java`

---

##  Database Structure

- Local SQLite database file: `SAS.db`
- Stores data for:
  - Admins
  - Cashiers
  - Orders
  - Payment methods
  - Inventory

No external database server needed — this is self-contained.

---

##  Usage

1. Open the project in an IDE like IntelliJ IDEA or Eclipse.
2. Make sure JavaFX libraries are correctly linked.
3. Run `MainProject.java` to launch the application.
4. Log in as Admin or Cashier (depending on pre-inserted credentials in the database).
5. Start managing orders, payments, and inventory.

---

##  Notes

- All UI is built using JavaFX with separate `.fxml` files.
- Controllers follow an MVC-like pattern.
- Data is updated live between UI and DB using JavaFX TableView bindings.
- Built originally as a group project to simulate a complete local POS system.
