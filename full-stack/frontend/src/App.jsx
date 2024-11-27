import './App.css'
import DCListRegionComponent from "./components/DCListRegionComponent.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import DCRegionComponent from "./components/DCRegionComponent.jsx";
import Index from "./components/Index.jsx";
import DCIndex from "./components/DCIndex.jsx";
import READIndex from "./components/READIndex.jsx";

function App() {

  return (
    <>
        <BrowserRouter>
            <HeaderComponent />
            <Routes>
                // http://localhost:3000
                <Route path='/' element={<Index />}></Route>

                // http://localhost:3000/read-index
                <Route path='/read-index' element={<READIndex />}></Route>

                // http://localhost:3000/dc-index
                <Route path='/dc-index' element={<DCIndex />}></Route>

                // http://localhost:3000/dc-regions
                <Route path='/dc-regions' element={<DCListRegionComponent />}></Route>

                // http://localhost:3000/add-region
                <Route path='/add-region' element={<DCRegionComponent />}></Route>

                // http://localhost:3000/update-region/#
                <Route path='/update-region/:id' element = {<DCRegionComponent />}></Route>
            </Routes>
            <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
