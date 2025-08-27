import React, { useEffect, useState } from "react";
import axios from "axios";

const App = () => {
  const [books, setBooks] = useState([]);
  const [bookTitle, setBookTitle] = useState("");
  const [authorName, setAuthorName] = useState("");
  const [updateId, setUpdateId] = useState(null);

  const baseURL = "http://localhost:9090";

  const fetchBooks = async () => {
    try {
      const res = await axios.get(`${baseURL}/getAllBooks`);
      setBooks(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const handleSubmit = async () => {
    if (!bookTitle || !authorName) return alert("Both fields are required");

    try {
      if (updateId) {
        await axios.put(`${baseURL}/update/${updateId}`, {
          bookTitle,
          authorName,
        });
        setUpdateId(null);
      } else {
        await axios.post(`${baseURL}/addbook`, { bookTitle, authorName });
      }

      setBookTitle("");
      setAuthorName("");
      fetchBooks();
    } catch (err) {
      console.error(err);
    }
  };

  const deleteBook = async (id) => {
    try {
      await axios.delete(`${baseURL}/delete`, { data: { id } });
      fetchBooks();
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    fetchBooks();
  }, []);

  return (
    <div
      style={{
        maxWidth: "600px",
        margin: "50px auto",
        padding: "20px",
        borderRadius: "10px",
        boxShadow: "0 4px 12px rgba(0,0,0,0.1)",
        fontFamily: "Arial, sans-serif",
        backgroundColor: "#f9f9f9",
      }}
    >
      <h1 style={{ textAlign: "center", marginBottom: "30px" }}>📚 Book Manager</h1>

      <div style={{ display: "flex", gap: "10px", marginBottom: "20px" }}>
        <input
          type="text"
          placeholder="Book Title"
          value={bookTitle}
          onChange={(e) => setBookTitle(e.target.value)}
          style={{
            flex: 1,
            padding: "10px",
            borderRadius: "5px",
            border: "1px solid #ccc",
          }}
        />
        <input
          type="text"
          placeholder="Author Name"
          value={authorName}
          onChange={(e) => setAuthorName(e.target.value)}
          style={{
            flex: 1,
            padding: "10px",
            borderRadius: "5px",
            border: "1px solid #ccc",
          }}
        />
        <button
          onClick={handleSubmit}
          style={{
            padding: "10px 20px",
            borderRadius: "5px",
            border: "none",
            backgroundColor: "#4caf50",
            color: "#fff",
            cursor: "pointer",
          }}
        >
          {updateId ? "Update" : "Add"}
        </button>
        {updateId && (
          <button
            onClick={() => {
              setUpdateId(null);
              setBookTitle("");
              setAuthorName("");
            }}
            style={{
              padding: "10px 15px",
              borderRadius: "5px",
              border: "none",
              backgroundColor: "#f44336",
              color: "#fff",
              cursor: "pointer",
            }}
          >
            Cancel
          </button>
        )}
      </div>

      <ul style={{ listStyle: "none", padding: 0 }}>
        <h2 style={{textAlign:"center", marginTop:"45px"}} > ALL BOOKS </h2>
        {books.map((book) => (
          <li
            key={book.id}
            style={{
              display: "flex",
              justifyContent: "space-between",
              alignItems: "center",
              padding: "10px",
              marginBottom: "10px",
              borderRadius: "5px",
              backgroundColor: "#fff",
              boxShadow: "0 2px 6px rgba(0,0,0,0.05)",
            }}
          >
            <span>
              <strong>{book.bookTitle}</strong> by {book.authorName}
            </span>
            <div>
              <button
                onClick={() => {
                  setUpdateId(book.id);
                  setBookTitle(book.bookTitle);
                  setAuthorName(book.authorName);
                }}
                style={{
                  padding: "5px 10px",
                  marginRight: "10px",
                  borderRadius: "5px",
                  border: "none",
                  backgroundColor: "#2196f3",
                  color: "#fff",
                  cursor: "pointer",
                }}
              >
                Edit
              </button>
              <button
                onClick={() => deleteBook(book.id)}
                style={{
                  padding: "5px 10px",
                  borderRadius: "5px",
                  border: "none",
                  backgroundColor: "#f44336",
                  color: "#fff",
                  cursor: "pointer",
                }}
              >
                Delete
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default App;
