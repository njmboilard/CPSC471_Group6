import './App.css'
import {BrowserRouter, Routes, Route} from "react-router-dom";

import Index from "./components/Index.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";

import Reader from "./components/read/Reader.jsx";
import RDListRegion from "./components/read/RD-ListRegion.jsx";
import RDListSubdivision from "./components/read/RD-ListSubdivision.jsx";
import RDListLocation from "./components/read/RD-ListLocation.jsx";
import RDListPlan from './components/read/RD-ListPlan.jsx';
import RDListProject from './components/read/RD-ListProject.jsx';
import RDListAssignedPlan from './components/read/RD-ListAssignedPlan.jsx';
import RDListIssue from './components/read/RD-ListIssue.jsx';
import RDListPersonnel from './components/read/RD-ListPersonnel.jsx';

import DocumentControl from "./components/documentcontrol/DocumentControl.jsx";
import DCListRegion from "./components/documentcontrol/DC-ListRegion.jsx";
import DCRegion from "./components/documentcontrol/DC-Region.jsx";
import DCListSubdivision from './components/documentcontrol/DC-ListSubdivision.jsx';
import DCSubdivision from './components/documentcontrol/DC-Subdivision.jsx';
import DCListLocation from './components/documentcontrol/DC-ListLocation.jsx';
import DCLocation from './components/documentcontrol/DC-Location.jsx';
import DCListPlan from './components/documentcontrol/DC-ListPlan.jsx';
import DCPlan from './components/documentcontrol/DC-Plan.jsx';
import DCListProject from './components/documentcontrol/DC-ListProject.jsx';
import DCProject from './components/documentcontrol/DC-Project.jsx';
import DCListIssue from './components/documentcontrol/DC-ListIssue.jsx';
import DCIssue from './components/documentcontrol/DC-Issue.jsx';
import DCListAssignedPlan from './components/documentcontrol/DC-ListAssignedPlan.jsx';
import DCListPersonnel from './components/documentcontrol/DC-ListPersonnel.jsx';
import DCPersonnel from './components/documentcontrol/DC-Personnel.jsx';
import DCProjectManager from './components/documentcontrol/DC-ProjectManager.jsx';
import DCContractDesigner from './components/documentcontrol/DC-ContractDesigner.jsx';
import DCInHouseDesigner from './components/documentcontrol/DC-InHouseDesigner.jsx';
import DCFieldStaff from './components/documentcontrol/DC-FieldStaff.jsx';

function App() {

  return (
    <>
        <BrowserRouter>
            <HeaderComponent />
            <Routes>
                {/* http://localhost:3000 */}
                <Route path='/' element={<Index />}></Route>

                {/* Reader ----------------------------------------------------------------------------------------- */}

                {/* http://localhost:3000/reader */}
                <Route path='/reader' element={<Reader />}></Route>

                {/* http://localhost:3000/reader/regions */}
                <Route path='/reader/regions' element={<RDListRegion />}></Route>

                {/* http://localhost:3000/reader/regions/#/subdivisions*/}
                <Route path='/reader/regions/:id/subdivisions' element={<RDListSubdivision />}></Route>

                {/* http://localhost:3000/reader/regions/#/subdivisions/chopcode/locations*/}
                <Route path='/reader/regions/:id/subdivisions/:chopcode/locations' element={<RDListLocation />}></Route>

                {/* http://localhost:3000/reader/regions/#/subdivisions/chopcode/locations/mileage/plans*/}
                <Route path='/reader/regions/:id/subdivisions/:chopcode/locations/:mileage/plans' element={<RDListPlan />}></Route>

                {/* http://localhost:3000/reader/projects */}
                <Route path='/reader/projects' element={<RDListProject />}></Route>

                {/* http://localhost:3000/reader/projects/#/personnel */}
                <Route path='/reader/projects/:id/personnel' element={<RDListPersonnel />}></Route>

                {/* http://localhost:3000/reader/projects/#/assignedplans */}
                <Route path='/reader/projects/:id/assignedplans' element={<RDListAssignedPlan />}></Route>

                {/* http://localhost:3000/reader/projects/#/issues */}
                <Route path='/reader/projects/:id/issues' element={<RDListIssue />}></Route>

                {/* Document Control ------------------------------------------------------------------------------- */}

                {/* http://localhost:3000/documentcontrol */}
                <Route path='/documentcontrol' element={<DocumentControl />}></Route>

                {/* http://localhost:3000/documentcontrol/regions */}
                <Route path='/documentcontrol/regions' element={<DCListRegion />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/add */}
                <Route path='/documentcontrol/regions/add' element={<DCRegion />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/update/# */}
                <Route path='/documentcontrol/regions/update/:id' element = {<DCRegion />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/#/subdivisions */}
                <Route path='/documentcontrol/regions/:id/subdivisions' element={<DCListSubdivision />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/#/subdivisions/add */}
                <Route path='/documentcontrol/regions/:id/subdivisions/add' element={<DCSubdivision />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/#/subdivisions/update/# */}
                <Route path='/documentcontrol/regions/:id/subdivisions/update/:chopcode' element = {<DCSubdivision />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/#/subdivisions/chopcode/locations */}
                <Route path='/documentcontrol/regions/:id/subdivisions/:chopcode/locations' element={<DCListLocation />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/#/subdivisions/chopcode/locations/add */}
                <Route path='/documentcontrol/regions/:id/subdivisions/:chopcode/locations/add' element={<DCLocation />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/#/subdivisions/chopcode/locations/update/# */}
                <Route path='/documentcontrol/regions/:id/subdivisions/:chopcode/locations/update/:mileage' element = {<DCLocation />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/#/subdivisions/chopcode/locations/mileage/plans */}
                <Route path='/documentcontrol/regions/:id/subdivisions/:chopcode/locations/:mileage/plans' element={<DCListPlan />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/#/subdivisions/chopcode/locations/mileage/plans/add */}
                <Route path='/documentcontrol/regions/:id/subdivisions/:chopcode/locations/:mileage/plans/add' element={<DCPlan />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/#/subdivisions/chopcode/locations/mileage/plans/update/# */}
                <Route path='/documentcontrol/regions/:id/subdivisions/:chopcode/locations/:mileage/plans/update/:drawingnumber' element = {<DCPlan />}></Route>

                {/* http://localhost:3000/documentcontrol/projects */}
                <Route path='/documentcontrol/projects' element={<DCListProject />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/add */}
                <Route path='/documentcontrol/projects/add' element={<DCProject />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/update/# */}
                <Route path='/documentcontrol/projects/update/:id' element={<DCProject />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/issues */}
                <Route path='/documentcontrol/projects/:id/issues' element={<DCListIssue />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/issues */}
                <Route path='/documentcontrol/projects/:id/issues/add' element={<DCIssue />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/issues */}
                <Route path='/documentcontrol/projects/:id/issues/update/:issueid' element={<DCIssue />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/assignedplans */}
                <Route path='/documentcontrol/projects/:id/assignedplans' element={<DCListAssignedPlan />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/personnel */}
                <Route path='/documentcontrol/projects/:id/personnel' element={<DCListPersonnel />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/personnel/add/type */}
                <Route path='/documentcontrol/projects/:id/personnel/add/projectmanager' element={<DCProjectManager />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/personnel/update/type/# */}
                <Route path='/documentcontrol/projects/:id/personnel/update/projectmanager/:pmid' element={<DCProjectManager />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/personnel/add/type */}
                <Route path='/documentcontrol/projects/:id/personnel/add/contractdesigner' element={<DCContractDesigner />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/personnel/update/type/# */}
                <Route path='/documentcontrol/projects/:id/personnel/update/contractdesigner/:cdid' element={<DCContractDesigner />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/personnel/add/type */}
                <Route path='/documentcontrol/projects/:id/personnel/add/inhousedesigner' element={<DCInHouseDesigner />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/personnel/update/type/# */}
                <Route path='/documentcontrol/projects/:id/personnel/update/inhousedesigner/:ihdid' element={<DCInHouseDesigner />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/personnel/add/type */}
                <Route path='/documentcontrol/projects/:id/personnel/add/fieldstaff' element={<DCFieldStaff />}></Route>

                {/* http://localhost:3000/documentcontrol/projects/#/personnel/update/type/# */}
                <Route path='/documentcontrol/projects/:id/personnel/update/fieldstaff/:fsid' element={<DCFieldStaff />}></Route>

            </Routes>
            <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
