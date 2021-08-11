import React, { Component } from "react";

import Navbar from "./Navbar";
import "./WhoAreWe.css";

class WhoAreWe extends Component {
  render() {
    return (
      <div>
        <Navbar />
        <section class="welcome">
            <div>
                <h1>Who We Are</h1>
            </div>
        </section>
        <div class="container">
            <section class="main-bar">
                <div class="container">
                    <p>Here at SpyGlass, we offer a basic product which any human being can use. This allows us not just make a profit but a difference in the lives of our users.</p>
                </div>
            </section>
            <aside class="side-bar">
                <div class="container">
                    <p>Why Us?</p>
                </div>
            </aside>
        </div>
        <div class="container">
            <section class="main-bar">
                <div class="container">
                    <p>We are here to help you achieve your goals. We provide a service, which will elavate you to conquer and a ontain your dream by just entering a small amount of data.</p>
                </div>
            </section>
            <aside class="side-bar">
                <div class="container">
                    <p>What can we do for you?</p>
                </div>
            </aside>
        </div>
        
      </div>
    );
  }
}

export default WhoAreWe;
