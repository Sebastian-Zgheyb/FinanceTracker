import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [expenses, setExpenses] = useState([]);

  // Dummy data for demonstration
  useEffect(() => {
    // Fetch expenses from backend (replace with actual API call)
    const dummyExpenses = [
      { id: 1, description: 'Groceries', amount: 50 },
      { id: 2, description: 'Utilities', amount: 110 },
      { id: 3, description: 'Rent', amount: 1200 },
    ];
    setExpenses(dummyExpenses);
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Personal Finance Management</h1>
        <div className="expenses-container">
          <h2>Expenses</h2>
          <ul>
            {expenses.map(expense => (
              <li key={expense.id}>
                <strong>{expense.description}</strong>: ${expense.amount}
              </li>
            ))}
          </ul>
        </div>
        <div className="add-expense-form">
          <h2>Add Expense</h2>
          <form>
            <div>
              <label htmlFor="description">Description:</label>
              <input type="text" id="description" name="description" />
            </div>
            <div>
              <label htmlFor="amount">Amount:</label>
              <input type="number" id="amount" name="amount" />
            </div>
            <button type="submit">Add Expense</button>
          </form>
        </div>
      </header>
    </div>
  );
}

export default App;
