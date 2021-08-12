import React, { Component } from "react";
import "./App.css";
import Navbar from "./Navbar";

class Home extends Component {
  render() {
    return (
      <div>
        <Navbar />

        <header class="masthead">
              <div class="container px-4 px-lg-5 h-100">
                  <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
                      <div class="col-lg-8 align-self-end">
                        <h1 class="font-link">SpyGlass</h1>
                      </div>
                      <div class="col-lg-8 align-self-baseline">
                        <p class="text-white-75 font-link"><u>&nbsp;Saving Money Has Never Been Easier&nbsp;</u></p>
                      </div>
                  </div>
              </div>
          </header>

          <section class="page-section bg-secondary about" id="about">
            <div class="container px-4 px-lg-5">
            <div class="row gx-4 gx-lg-5 justify-content-center">
                <div class="col-lg-8 text-center">
                    <h2 class="text-black mt-0 section-link">Save for stuff that matters to you.</h2>
                    <hr class="divider divider-light" />
                    <p class="text-white-75 mb-4 description-font">Save and earn towards as many goals as you can dream up.</p>
                </div>
                </div>
            </div>
        </section>
      </div>
    );
  }
}

export default Home;
