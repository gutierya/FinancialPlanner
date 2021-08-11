import React, { Component } from 'react';

import Navbar from './Navbar';
import { Link } from 'react-router-dom';
import {
  FormControl,
  InputLabel,
  Input,
  Button,
  TextField
} from "@material-ui/core";


class Contact extends Component {
  
  render() {
    
    return (
      <div>
        <Navbar/>

        <div className = "float-center">
        <form style={{ position: 'absolute', left: '50%', top: '50%',transform: 'translate(-50%, -50%)'}}>
        
          <h1>Contact Form</h1>
          

          <FormControl margin="normal" fullWidth>
            <InputLabel htmlFor="name">Name</InputLabel>
            <Input id="name" type="text" />
          </FormControl>

          <FormControl margin="normal" fullWidth>
            <InputLabel htmlFor="email">Email</InputLabel>
            <Input id="email" type="email" />
          </FormControl>

          <FormControl margin="normal" fullWidth>
            <InputLabel htmlFor="email">Message</InputLabel>
            <Input id="email" multiline rows={10} />
          </FormControl>

          <Button variant="contained" color="primary" size="medium">
            Send
          </Button>
        </form>
        </div>
      </div>
    );
  }
}

export default Contact;