# 📱 Android Pay Calculator App

Welcome to the **Pay Calculator App**! This Android app helps you quickly calculate your pay based on the number of hours worked and your hourly rate. It even handles overtime calculations, taxes, and displays a detailed breakdown with a smooth user experience.

## ✨ Features

- **🧮 Calculate Pay**: Input your hours worked and hourly rate to compute regular, overtime, and total pay.
- **🕒 Overtime Calculation**: Automatically calculates overtime pay at 1.5x the hourly rate for hours exceeding 40 hours per week.
- **💸 Tax Deduction**: Applies an 18% tax rate on your total earnings to estimate your post-tax pay.
- **🍔 Popup Menu**: Easily navigate between the **Main Page** and **About Page** using a sleek popup menu.
- **🎬 Animations**: Enjoy smooth fade-in animations when displaying the calculated result.

## 📂 Project Structure

```bash
ca.gbc.comp3074.assignment1/
├── MainActivity.java         # Main logic for the app, including pay calculation
├── AboutActivity.java        # Displays the about section with user info
├── res/
│   ├── layout/
│   │   └── activity_main.xml  # Layout for the MainActivity
│   ├── drawable/
│   │   └── ic_home.xml        # Icon for home menu item
│   └── anim/
│       └── fade_in.xml        # Fade-in animation for results
├── menu/
│   └── menu_main.xml          # Menu for navigation
```

## 🚀 Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo/pay-calculator-app.git
   ```

2. **Open in Android Studio**:
   Import the project into Android Studio, and sync Gradle.

3. **Run the app**:
   Run the app on your Android device or emulator.

## 🎛️ How to Use

1. **Input the Number of Hours**: Enter the number of hours you worked.
2. **Enter Hourly Rate**: Enter your hourly rate.
3. **Click "Calculate"**: The app will display your regular pay, overtime pay (if applicable), total pay, and tax deduction.
4. **Navigate**: Use the menu icon in the top-right corner to access the **About Page**.

### Overtime Pay Calculation:

- If you work **40 hours or less**, the app calculates your regular pay.
- If you work **more than 40 hours**, the app calculates overtime pay at **1.5x** your hourly rate.

### Tax Calculation:

- The app applies a **flat 18% tax** on your total pay.

## 📋 Code Highlights

### 1. **Calculate Pay Logic**
```java
if (hoursWorked <= 40) {
    regularPay = hoursWorked * hourlyRate;
    totalPay = regularPay;
} else {
    regularPay = 40 * hourlyRate;
    overTimePay = (hoursWorked - 40) * (hourlyRate * 1.5);
    totalPay = regularPay + overTimePay;
}
double tax = totalPay * 0.18;
```

### 2. **Smooth Animations**
```java
fadeInANIMATION = AnimationUtils.loadAnimation(this, R.anim.fade_in);
displayResult.startAnimation(fadeInANIMATION);
```

### 3. **Menu Navigation**
```java
popupMenu.setOnMenuItemClickListener(item -> {
    if(item.getItemId() == R.id.action_about) {
        Intent aboutTransfer = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(aboutTransfer);
    }
    return true;
});
```



## ⚙️ Tech Stack

- **Android SDK**: Native Android development
- **Java**: Primary programming language
- **XML**: Layout and UI components
- **Animations**: `AnimationUtils` for smooth transitions
- **Popup Menu**: For user-friendly navigation

## 👨‍💻 Developer

- **Cozimo Audiatore** - Android Developer

## 📜 License

This project is licensed under the MIT License.

---

Enjoy using the Pay Calculator app! If you have any questions, feel free to reach out. 😊