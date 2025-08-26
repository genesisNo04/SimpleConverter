import { useState } from 'react'
import './App.css'
import { useNavigate, useLocation } from 'react-router-dom';

function Result() {
  const location = useLocation();
  const navigate = useNavigate();
  const { result, activeTab } = location.state || {};

  const tabConfig = {
    length: {
      valueLabel: "Enter the length to convert",
      fromLabel: "Unit to Convert from",
      toLabel: "Unit to Convert to",
    },
    weight: {
      valueLabel: "Enter the weight to convert",
      fromLabel: "Unit to Convert from",
      toLabel: "Unit to Convert to",
    },
    temperature: {
      valueLabel: "Enter the temperature to convert",
      fromLabel: "Unit to Convert from",
      toLabel: "Unit to Convert to",
    },
  };

  return (
    <div className="container">
      <div className="card">
        <div className="title">Unit Converter</div>
        <div className="tabs">
          <div className={`tab ${activeTab === "length" ? "active" : ""}`}>Length</div>
          <div className={`tab ${activeTab === "weight" ? "active" : ""}`}>Weight</div>
          <div className={`tab ${activeTab === "temperature" ? "active" : ""}`}>Temperature</div>
        </div>

        <p>Result of your calculation</p>
        <div className="result">
          <span>{result || "No result available"}</span>
        </div>

        <button onClick={() => navigate("/")}>Reset</button>
      </div>
    </div>
  )
}

export default Result
