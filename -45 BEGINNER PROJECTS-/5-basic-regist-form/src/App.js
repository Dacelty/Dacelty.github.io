import React, { useState } from "react";
import "./index.css";

export default function App() {
  const [val, setVal] = useState ({
    firstName: "",
    lastName: "",
    email: "",
  });

  const [submitted, setSubmitted] = useState(false)
  const [valid, setValid] = useState(false);

/*   const handleFN_inputChange = (event) => {
    setVal({...val, firstName:event.target.value})
  }

  const handleLN_inputChange = (event) => {
    setVal({...val, lastName:event.target.value})
  }

  const handleEm_inputChange = (event) => {
    setVal({...val, email:event.target.value})
  } */

  const handleSub = (event) => {
    event.preventDefault();
    if (val.firstName && val.lastName && val.email){
      setValid(true);
    }
    setSubmitted(true);
  }

  return (
    <div class="form-container">
      <form class="register-form" onSubmit={handleSub}>
        {/* Uncomment the next line to show the success message */}
        {submitted && valid ? <div class="success-message">Success! Thank you for registering</div> : null}
        <input
          onChange={e => setVal({...val, firstName:e.target.value})}
          id="first-name"
          value={val.firstName}
          class="form-field"
          type="text"
          placeholder="First Name"
          name="firstName"
        />
        {submitted && !val.firstName ? <span id="first-name-error">Please enter a first name</span> : null}
        <input
          onChange={e => setVal({...val, lastName:e.target.value})}
          id="last-name"
          class="form-field"
          type="text"
          placeholder="Last Name"
          name="lastName"
        />
        {submitted && !val.lastName ? <span id="last-name-error">Please enter a last name</span> : null} 
        <input
          onChange={e => setVal({...val, email:e.target.value})}
          id="email"
          class="form-field"
          type="text"
          placeholder="Email"
          name="email"
        />
        {submitted && !val.email ? <span id="first-name-error">Please enter an email</span> : null}
        <button class="form-field" type="submit">
          Register
        </button>
      </form>
    </div>
  );
}