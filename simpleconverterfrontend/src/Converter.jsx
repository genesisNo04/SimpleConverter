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

  const handleConvert = async () => {
    try {
      const typeConvert = activeTab;
      const url = `http://localhost:8080/${typeConvert}?value=${initialValue}&from=${fromUnit}&to=${toUnit}`
      console.log(url);
    // For now, let's just simulate a result
    const response = await fetch(url);
    console.log(response);
    if (!response.ok) {
      throw new Error("Network response was not ok");
    }
    const convertedValue = await response.json();

    // Navigate to result page and pass data
    navigate("/result", {
      state: {
        activeTab,
        result: `${initialValue} ${fromUnit} = ${Number(convertedValue).toFixed(2)} ${toUnit}`,
      },
    });
    } catch (error) {
      console.error("Erro converting value: ", error);
      alert("Conversion failed. Check console for details.");
    }
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
