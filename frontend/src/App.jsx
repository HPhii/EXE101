import { Navigate, Route, Routes } from "react-router-dom";
import FloatingShape from "./components/FloatingShape";

import SignUpPage from "./pages/SignUpPage";
import LoginPage from "./pages/LoginPage";
import EmailVerificationPage from "./pages/EmailVerificationPage";
import DashboardPage from "./pages/DashboardPage";
import ForgotPasswordPage from "./pages/ForgotPasswordPage";
import ResetPasswordPage from "./pages/ResetPasswordPage";


import LoadingSpinner from "./components/LoadingSpinner";

import { Toaster } from "react-hot-toast";
import { useAuthStore } from "./store/authStore";
import { useEffect } from "react";
import HomePage from "./pages/HomePage";

function App() {
	// const { isCheckingAuth, checkAuth, isAuthenticated, user } = useAuthStore();

	// useEffect(() => {
	// 	checkAuth();
	// }, [checkAuth]);

	// if (isCheckingAuth) return <LoadingSpinner />;

	// // 🔁 Điều hướng root `/` tùy theo trạng thái xác thực
	// const RootRoute = () => {
	// 	if (isAuthenticated && user?.isVerified) {
	// 		return <DashboardPage />;
	// 	}

	// };

	return (
		<div className='min-h-screen bg-gradient-to-br from-gray-900 via-green-900 to-emerald-900 flex items-center justify-center relative overflow-hidden'>
			<FloatingShape color='bg-green-500' size='w-64 h-64' top='-5%' left='10%' delay={0} />
			<FloatingShape color='bg-emerald-500' size='w-48 h-48' top='70%' left='80%' delay={5} />
			<FloatingShape color='bg-lime-500' size='w-32 h-32' top='40%' left='-10%' delay={2} />

			<Routes>
				<Route path='/' element={<HomePage />} />

				<Route
					path='/signup'
					element={
						// <RedirectAuthenticatedUser>
							<SignUpPage />
						// </RedirectAuthenticatedUser>
					}
				/>
				<Route
					path='/login'
					element={
						// <RedirectAuthenticatedUser>
							<LoginPage />
						// </RedirectAuthenticatedUser>
					}
				/>
				<Route path='/verify-email' element={<EmailVerificationPage />} />
				<Route
					path='/forgot-password'
					element={
						// <RedirectAuthenticatedUser>
							<ForgotPasswordPage />
						// </RedirectAuthenticatedUser>
					}
				/>
				<Route
					path='/reset-password'
					element={
						// <RedirectAuthenticatedUser>
							<ResetPasswordPage />
						// </RedirectAuthenticatedUser>
					}
				/>
				<Route path='*' element={<Navigate to='/' replace />} />
			</Routes>

			<Toaster />
		</div>
	);
}

export default App;
