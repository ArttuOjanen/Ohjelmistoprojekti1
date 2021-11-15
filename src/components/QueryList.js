import React, { useState, useEffect } from 'react';
import { Express } from 'express';

function QueryList() {
    const [question, setQuestion] = useState([]);

    const express = require("express");
    const app = express();
    const cors = require("cors");

    app.use(
        cors({
            origin: "*",
        })
    )
    app.get('/', function (req, res) {
        res.send('Hello World')
    })
    app.listen(3000);


    useEffect(() => {
        // Fetch questions
       fetchQuestions();
    }, []);

    const fetchQuestions = () => {
        fetch('http://localhost:8080/test',
        {
        method: 'GET',
        headers: {'Content-type':'application/json'},
        }
        )
        .then(response => response.json())
        .then(data => setQuestion(data._embedded.question))
        .catch(err => console.error(err))
    }


    return(
        <div>

            <p>aaaa{question}</p>
        </div>
    );
}

export default QueryList;