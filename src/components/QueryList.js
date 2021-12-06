import React, { useState, useEffect } from 'react';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import Button from '@mui/material/Button';

function QueryList() {
    
    const [question, setQuestion] = useState([]);
    const url = 'http://localhost:8080/api/queries';


    useEffect(() => {
       fetchQuestions();
    }, []);

    const fetchQuestions = () => {
        fetch(url, {
          mode: 'no-cors',
          referrerPolicy: 'no-referrer'
        })
        .then(response => response.json())
        .then(data => setQuestion(data._embedded.queries))
        .catch(err => console.error(err))
    }
  
        


    return(
        <div>
        <div>
       
<  FormControl component="fieldset">
  <FormLabel component="legend">{question}</FormLabel>
  <RadioGroup
    defaultValue="kyllä"
    name="radio-buttons-group"
  >
    <FormControlLabel value="kyllä" control={<Radio />} label="Kyllä" />
    <FormControlLabel value="ei" control={<Radio />} label="ei" />
  </RadioGroup>
</FormControl>
        
        </div>
        <Button variant="contained">Lähetä</Button>
        {}
        </div>
    );
}

export default QueryList;