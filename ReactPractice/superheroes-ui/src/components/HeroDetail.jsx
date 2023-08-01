import React, { useState } from 'react'
import images from '..'
import Button from 'react-bootstrap/Button'
import Card from 'react-bootstrap/Card'
import Row from 'react-bootstrap/esm/Row'
import Col from 'react-bootstrap/esm/Col'


const HeroDetail = (props) => {

    const[counter, setCounter] = useState(0);
    const incrementCounter=()=>{
        setCounter(counter+1);
        props.parentCount(props.info.alias)
    }
    
  return (
    <Card>
     <div className="imgContainer">
        <Card.Img variant="top" src={images[props.info.alias.replaceAll(/\s/g,'')]} alt={props.info.name} height="250px"/>
    </div>
    <Card.Body>
        <Card.Title>Alias: {props.info.alias}</Card.Title>
        <Card.Text>Name: {props.info.name}</Card.Text>
        <Row>
            <Col><Button variant="primary" onClick={incrementCounter}>Like</Button></Col>
            <Col>{counter > 0 && <Card.Text >Likes: {counter}</Card.Text>}</Col>
        </Row>
        
    </Card.Body>
    
    </Card>
  )
}

export default HeroDetail