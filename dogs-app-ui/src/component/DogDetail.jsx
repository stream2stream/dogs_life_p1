import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
const DogDetail = (props) => {
    let showOwner = false;
    const nowShow = () => {
        showOwner = true;
        console.log("here")
    }
    
  return (
    
    
    <Card onClick={nowShow}>
      <div className='imgContainer'>
        <Card.Title>{props.info.name}</Card.Title>
      </div>
      <Card.Body >
        <Card.Text >Age: {props.info.age}</Card.Text>
       {showOwner && <Card.Text >Owner: {props.info.owner_id} </Card.Text>}
        <Button variant="danger">Delete</Button>
      </Card.Body>
    </Card>
  )
}

export default DogDetail