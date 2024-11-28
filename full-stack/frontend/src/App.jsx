import './App.css'
import {BrowserRouter, Routes, Route} from "react-router-dom";

import Index from "./components/Index.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";

import READIndex from "./components/read/RD-Index.jsx";

import DCIndex from "./components/documentcontrol/DC-Index.jsx";
import DCListRegion from "./components/documentcontrol/DC-ListRegion.jsx";
import DCRegion from "./components/documentcontrol/DC-Region.jsx";
import DCListSubdivision from "./components/documentcontrol/DC-ListSubdivision.jsx";
import DCSubdivision from "./components/documentcontrol/DC-Subdivision.jsx";
import DCListLocation from "./components/documentcontrol/DC-ListLocation.jsx";
import DCLocation from "./components/documentcontrol/DC-Location.jsx";
import DCListPlan from "./components/documentcontrol/DC-ListPlan.jsx";
import DCPlan from "./components/documentcontrol/DC-Plan.jsx";
import DCListProject from "./components/documentcontrol/DC-ListProject.jsx";
import DCProject from "./components/documentcontrol/DC-Project.jsx";

function App() {

  return (
    <>
        <BrowserRouter>
            <HeaderComponent />
            <Routes>
                {/* http://localhost:3000 */}
                <Route path='/' element={<Index />}></Route>

                {/* http://localhost:3000/read-index */}
                <Route path='/read-index' element={<READIndex />}></Route>

                {/* http://localhost:3000/dc-index */}
                <Route path='/dc-index' element={<DCIndex />}></Route>

                {/* http://localhost:3000/dc-regions */}
                <Route path='/dc-regions' element={<DCListRegion />}></Route>

                {/* http://localhost:3000/add-region */}
                <Route path='/add-region' element={<DCRegion />}></Route>

                {/* http://localhost:3000/update-region/# */}
                <Route path='/update-region/:id' element = {<DCRegion />}></Route>

                {/* http://localhost:3000/dc-subdivisions */}
                <Route path='/dc-subdivisions' element={<DCListSubdivision />}></Route>

                {/* http://localhost:3000/add-subdivision */}
                <Route path='/add-subdivision' element={<DCSubdivision />}></Route>

                {/* http://localhost:3000/update-subdivision/# */}
                <Route path='/update-subdivision/:id' element = {<DCSubdivision />}></Route>

                {/* http://localhost:3000/dc-locations */}
                <Route path='/dc-locations' element={<DCListLocation />}></Route>

                {/* http://localhost:3000/add-location */}
                <Route path='/add-location' element={<DCLocation />}></Route>

                {/* http://localhost:3000/update-location/# */}
                <Route path='/update-location/:id' element = {<DCLocation />}></Route>

                {/* http://localhost:3000/dc-plans */}
                <Route path='/dc-plans' element={<DCListPlan />}></Route>

                {/* http://localhost:3000/add-plan */}
                <Route path='/add-plan' element={<DCPlan />}></Route>

                {/* http://localhost:3000/update-plan/# */}
                <Route path='/update-plan/:id' element = {<DCPlan />}></Route>

                {/* http://localhost:3000/dc-projects */}
                <Route path='/dc-projects' element={<DCListProject />}></Route>

                {/* http://localhost:3000/add-project */}
                <Route path='/add-project' element={<DCProject />}></Route>

                {/* http://localhost:3000/update-plan/# */}
                <Route path='/update-project/:id' element = {<DCProject />}></Route>

            </Routes>
            <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
