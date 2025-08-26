import { useState } from 'react'
import './App.css'
import { useNavigate } from 'react-router-dom';

function Converter() {
    const [activeTab, setActiveTab] = useState("length");
    const [initialValue, setInitialValue] = useState("");
    const [fromUnit, setFromUnit] = useState("");
    const [toUnit, setToUnit] = useState("");
    const navigate = useNavigate();

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

  const handleConvert = () => {
    // For now, let's just simulate a result
    const result = `${initialValue} ${fromUnit} = 123 ${toUnit}`;

    // Navigate to result page and pass data
    navigate("/result", {
      state: {
        activeTab,
        result,
      },
    });
  };

  return (
    <div className="container">
      {/* Left Card */}
      <div className="card">
        <div className="title">Unit Converter</div>

        {/* Tabs */}
        <div className="tabs">
          <a
            href="#"
            className={`tab ${activeTab === "length" ? "active" : ""}`}
            onClick={(e) => {
              e.preventDefault();
              setActiveTab("length");
            }}
          >
            Length
          </a>
          <a
            href="#"
            className={`tab ${activeTab === "weight" ? "active" : ""}`}
            onClick={(e) => {
              e.preventDefault();
              setActiveTab("weight");
            }}
          >
            Weight
          </a>
          <a
            href="#"
            className={`tab ${activeTab === "temperature" ? "active" : ""}`}
            onClick={(e) => {
              e.preventDefault();
              setActiveTab("temperature");
            }}
          >
            Temperature
          </a>
        </div>

        {/* Dynamic Inputs */}
        <label htmlFor="initial_value">{tabConfig[activeTab].valueLabel}</label>
        <input
          type="text"
          id="initial_value"
          value={initialValue}
          onChange={(e) => setInitialValue(e.target.value)}
        />

        <label htmlFor="initial_unit">{tabConfig[activeTab].fromLabel}</label>
        <input
          type="text"
          id="initial_unit"
          value={fromUnit}
          onChange={(e) => setFromUnit(e.target.value)}
        />

        <label htmlFor="converted_unit">{tabConfig[activeTab].toLabel}</label>
        <input
          type="text"
          id="converted_unit"
          value={toUnit}
          onChange={(e) => setToUnit(e.target.value)}
        />

        <button onClick={handleConvert}>Convert</button>
      </div>
    </div>
  )
}

export default Converter
